//1
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.IndexToString

val spark = SparkSession.builder().getOrCreate()

val data = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/brise/Documents/Github/iris/iris.csv")

data.na.drop()

//2
data.columns

//3
data.printSchema()

//4
data.show(5)

//5
data.describe().show()

//6
val assembler = new VectorAssembler().setInputCols(Array("sepal_length","sepal_width","petal_length","petal_width")).setOutputCol("features")

val asmb = assembler.transform(data)

asmb.show()

val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies").fit(data)

val lblInd = new StringIndexer().setInputCol("species").setOutputCol("indexedspecies")

val indx = lblInd.fit(data).transform(data)

indx.show()

println(s"Found species: ${labelIndexer.labels.mkString("[", ", ", "]")}")

val indexed = labelIndexer.transform(data).withColumnRenamed("indexedSpecies", "label")

val features = assembler.transform(indexed)

features.show()

val featureIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedSpecies").fit(indexed)

val splits = features.randomSplit(Array(0.6, 0.4), seed = 1234L)

val train = splits(0)

val test = splits(1)

val layers = Array[Int](4, 5, 4, 3)

//7
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

val model = trainer.fit(train)

val result = model.transform(test)

val predictionAndLabels = result.select("prediction", "label")

val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//8
println(s"\n\nTest set accuracy = ${evaluator.evaluate(predictionAndLabels)}")