//1.- Importar librerías
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.log4j._

//2.- Minimizar errores
Logger.getLogger("org").setLevel(Level.ERROR)

//3.- Crear sesión de spark
val spark = SparkSession.builder.getOrCreate()

//4.- Cargar dataframe
val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/brise/Documents/GitHub/DatosMasivos/Evaluation/Wholesale_customers_data.csv")

//5.- Seleccionamos las columnas con las que vamos a trabajar
val feature_data = dataf.select("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")
feature_data.show

//6.- Creamos un nuevo objeto para ensamblar vectores
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen", "Detergents_Paper", "Delicassen")).setOutputCol("features")

//7.- Usamos assembler para transformar feature_data
val features = assembler.transform(feature_data)

//8.- Creamos el modelo KMeans con K=3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)

//9.- Evaluamos los grupos
val WSSSE = model.computeCost(features)
println(s"Within set sum of Squared Errors = $WSSSE")

//10.- Imprimimos los resultados
println("Cluster Centers: ")
model.clusterCenters.foreach(println)