//Importar librerías
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.mllib.linalg.{Vector, Vectors}

//Crear sesión de spark
val spark = SparkSession.builder.getOrCreate()

//Cargar dataframe
val dataf = spark.read.option("header",
"true").option("inferSchema","true")csv("Wholesale_customers_data.
csv")

//Seleccionamos las columnas con las que vamos a trabajar
val feature_data = dataf.select("Fresh", "Milk", "Grocery",
"Frozen", "Detergents_Paper", "Delicassen")
feature_data.show

//Creamos un nuevo objeto para ensamblar vectores
val assembler = new VectorAssembler().setInputCols(Array("Fresh",
"Milk", "Grocery", "Frozen", "Detergents_Paper",
"Delicassen")).setOutputCol("features")

//Usamos assembler para transformar feature_data
val features = assembler.transform(feature_data)

//Creamos el modelo KMeans con K=3
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)

//Evaluamos los grupos
val WSSSE = model.computeCost(features)
println(s"Within set sum of Squared Errors = $WSSSE")

//Imprimimos los resultados
println("Cluster Centers: ")
model.clusterCenters.foreach(println)