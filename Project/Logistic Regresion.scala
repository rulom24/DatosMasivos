//Import libraries 
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.log4j._

//Minimize errors
val spark = SparkSession.builder().getOrCreate()

//Define val on runtime and startTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//The data us loaded into the variable "data" in the format "bank_full.csv"
val data  = spark.read.option("header","true").option("inferSchema","true").option("delimiter", ";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")

//Rename the column ("y", lable)
val label = new StringIndexer().setInputCol("y").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

//Generate vector with the names of the columns to evaluate
val assembler = new VectorAssembler().setInputCols (Array ("balance", "day", "duration", "pdays", "previous")).setOutputCol("features")

//Define the assamble object to transform assembler.transform(newDF)
val data2 = assembler.transform(labeltransform)

//Index the labels
val training = data2.select("features", "label")

//Divide the data, 70%-30%
val splits = training.randomSplit(Array(0.7, 0.3), seed = 12345)

//Define 70% training and 30% testing
val train = splits(0)
val test = splits(1)

//Define the model for Logistic Regression
val lr = new  LogisticRegression().setMaxIter(10).setRegParam(0.1)
val model = lr.fit(train)
val result = model.transform(test)

val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print Accuracy
println(s"Accuraccy = ${evaluator.evaluate(result)}")
println(s"Test Error = ${(1.0 - (evaluator.evaluate(result)))}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000