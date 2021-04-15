//1. Iniciar sesión en Spark.
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
val spark = SparkSession.builder().getOrCreate()

//2. Cargar Netflix Stock CSV.
val NetDF = spark.read.option("header", "true")
            .option("inferSchema", "true")
            csv("C:\\Users\\brise\\Documents\\GitHub\\DatosMasivos\\Evaluation 1\\Netflix_2011_2016.csv")

//3. Cuales son los nombres de las columnas?
val ColNames: Array[String] = NetDF.columns
ColNames.foreach(name => println(s"$name"))

//4. Como se llama el esquema? 
NetDF.printSchema()

//5. Imprimir las primeras 5 columnas.
NetDF.head(5)

//6. Usa describe()
NetDF.describe()

//7.  Crea una nueva columna llamada "HV Ratio" que es la relacion entre el precio
//    de la columna "High" frente a la columna "Volumen" de acciones negociadas por un dia.
// Se agrego la nueva columna "HV Ratio" la cual tendra el resultado de la division de "High" entre "Volume".

val NetDF2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
df2.show()

//9. ¿Cual es el significado de la columna Cerrar "Close"?
// Respuesta: Es el cierre del mes.

//10. ¿Cual es el maximo y minimo de la columna "Volumen"?
df.select(max("Volume")).show()
df.select(min("Volume")).show()
