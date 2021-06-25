//Import libraries
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//Define val on runtime and starTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//The data is loaded int the variable "datos"
val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")
datosBank.show() 
val data = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")
val changes1 = data.withColumn("y",when(col("y").equalTo("yes"),1).otherwise(col("y")))
val changes2 = changes1.withColumn("y",when(col("y").equalTo("no"),2).otherwise(col("y")))
val newColumn = changes2.withColumn("y",'y.cast("Int"))

//Generate vector with the names of the columns to evaluate
val assembler = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Define the assembler object to transform assembler.transform(newDF)
val Ldata = assembler.transform(newColumn)

//Rename the column ("y", lable)
val changes = Ldata.withColumnRenamed("y", "label")
val feat = changes.select("label","features") 

//Divide the data, 70%-30%
val splits = feat.randomSplit(Array(0.7, 0.3), seed = 1234L)

//Define 70% training and 30% testing
val train = splits(0)
val test = splits(1)

//Define the model for Multilayer perceptron
val LayersN = Array[Int](5, 6, 3, 4)
val training = new MultilayerPerceptronClassifier().setLayers(LayersN).setBlockSize(128).setSeed(1234L).setMaxIter(100)
val model = training.fit(train)

val resultados = model.transform(test)
val predictionAndLabels = resultados.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print Accuracy
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
println(s"Test Error = ${(1.0 - (evaluator.evaluate(predictionAndLabels)))}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000