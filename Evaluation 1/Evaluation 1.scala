//Iniciar sesión en Spark
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
val spark = SparkSession.builder().getOrCreate()

//Cargar Netflix Stock CSV
val NetDF = spark.read.option("header", "true")
            .option("inferSchema", "true")
            csv("C:\\Users\\brise\\Documents\\GitHub\\DatosMasivos\\Evaluation 1\\Netflix_2011_2016.csv")

//Nombres de las columnas
val ColNames: Array[String] = NetDF.columns
ColNames.foreach(name => println(s"$name"))

NetDF.printSchema()

//Imprimir las primeras 5 columnas


//Usa describe()
NetDF.describe()

//Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la
//relación entre el precio de la columna “High” frente a la columna “Volume” de
//acciones negociadas por un día. (Hint: Es una operación de columnas).