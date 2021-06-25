//Import libraries
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.log4j._

//Minimize errors
Logger.getLogger("org").setLevel(Level.ERROR)

//Define val on runtime and startTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//Start a session in spark
val spark = SparkSession.builder.appName("DecisionTreeClassificationExample").getOrCreate()

//The data is loaded into the variable "data" in the format "bank_full.csv"
val data  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")

//Generate vector with the names of the columns to evaluate
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Define thhe vectorFeatures object to transform vectorFeatures.transform(newDF)
val features = vectorFeatures.transform(data)

//Rename the column ("y", lable)
val featuresLabel = features.withColumnRenamed("y", "label")

//Index the labels
val dataIndexed = featuresLabel.select("label","features")
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(dataIndexed)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(dataIndexed) // features with > 4 distinct values are treated as continuous.

//Divide the data, 70% training and 30% tersting
val Array(trainingData, testData) = dataIndexed.randomSplit(Array(0.7, 0.3))

//Define the model for the decision tree
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
val model = pipeline.fit(trainingData)
val predictions = model.transform(testData)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

//Print Accuracy
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000