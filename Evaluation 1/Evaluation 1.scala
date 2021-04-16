//1. Sign in to Spark.
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
val spark = SparkSession.builder().getOrCreate()

//2.Load Netflix Stock CSV.
val NetDF = spark.read.option("header", "true").option("inferSchema", "true")csv("C:\\Users\\brise\\Documents\\GitHub\\DatosMasivos\\Evaluation 1\\Netflix_2011_2016.csv")

//3. What are the names of the columns?
val ColNames: Array[String] = NetDF.columns
ColNames.foreach(name => println(s"$name"))

//4. What is the name of the scheme? 
NetDF.printSchema()

//5. Print the first 5 columns.
NetDF.head(5)

//6. Use describe()
NetDF.describe().show()

//7.  Create a new column called "HV Ratio" which is the relationship between the price
// of the "High" column in front of the "Volume" column of shares traded for one day.
// Added the new column "HV Ratio" which will have the result of the division of "High" by "Volume".
val NetDF2 = NetDF.withColumn("HV Ratio",NetDF("High")/NetDF("Volume"))
NetDF2.show()

//8.What day had the highest peak in the "close" column?
// Answer: There is no such column in the data frame.

//9. What is the meaning of the Close column "Close"?
// Answer: It is the end of the month.

//10. What is the maximum and minimum of the column "Volume"?
NetDF.select(max("Volume")).show()
NetDF.select(min("Volume")).show()

//11. Con sintaxis Scala/Spark $ conteste los siguientes: 

//a) ¿Cuantos dias fue la columna "Close" inferior a $600?
df.filter($"Close"<600).count()
 

// b) ¿Que porcentaje del tiempo fue la columna "High" mayor que $500?
(df.filter($"High" > 500).count() * 1.0/ df.count())*100

// c) ¿Cual es la correlacion de Pearson entre Columna "High" y la columna "Volume"?
df.select(corr("High","Volume")).show()

// Se importa la sintaxis de SPARK para la consulta de datos 
import spark.implicits._

// d) ¿Cual es el maximo de la columna "High" por año?
// Se agrego la columna "Year" del dato "Date", en la variable "yeardf"
val yeardf = df.withColumn("Year",year(df("Date")))
// Se selecciono a partir de la variable "yeardf" el año y el maximo de "High", a partir de maximos a minimo en los años
val yearmaxs = yeardf.select($"Year",$"High").groupBy("Year").max()
// Se dio como resultado el maximo de la columna "High" por año
val res = yearmaxs.select($"Year",$"max(High)")
res.orderBy("Year").show()

// e) ¿Cual es el promedio de la columna "Close" para cada mes del calendario?
// Se agrego la columna "Month" del dato "Date", en la variable "monthdf"
val monthdf = df.withColumn("Month",month(df("Date")))
// Se selecciono a partir de la variable "monthdf" el mes y el promedio de "Close"
val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()
// Se selecciono y mostro el promedio de la columna "Close" para cada mes del calendario
monthavgs.select($"Month",$"avg(Close)").orderBy("Month").show()
