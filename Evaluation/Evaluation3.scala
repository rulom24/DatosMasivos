//1.- Import libraries.
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.log4j._

//2.- Minimize errors.
Logger.getLogger("org").setLevel(Level.ERROR)

//3.-Create spark session.
val spark = SparkSession.builder.getOrCreate()

//4.- Load dataframe.
val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/brise/Documents/GitHub/DatosMasivos/Evaluation/Wholesale_customers_data.csv")

//5.- We select the columns with which we are going to work.
val feature_data = dataf.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")
feature_data.show

//6.- We create a new object to assemble vectors.
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

//7.- We use assembler to transform feature_data.
val features = assembler.transform(feature_data)

//8.- We reuse the KMeans model with K = 3.
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)

//9.- We evaluate the groups.
val WSSSE = model.computeCost(features)
println(s"Within set sum of Squared Errors = $WSSSE")

//10.- We print the results.
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
