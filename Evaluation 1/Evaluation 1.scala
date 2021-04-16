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
NetDF.columns.take(5)

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

//11.With Scala / Spark $ syntax answer the following:
//a) How many days was the "Close" column less than $ 600?
NetDF.filter($"Close"<600).count()
 

// b)What percentage of the time was the "High" column greater than $ 500?
(NetDF.filter($"High" > 500).count() * 1.0/ df.count())*100

// c) What is the Pearson correlation between Column "High" and column "Volume"?
NetDF.select(corr("High","Volume")).show()

// The SPARK syntax for the data query is imported.
import spark.implicits._

// d) What is the maximum in the "High" column per year?
// The column "Year" of the data "Date" was added, in the variable "yeardf"
val yeardf = NetDF.withColumn("Year",year(NetDF("Date")))
// The year and the maximum of "High" were selected from the variable "yeardf", from the maximum to the minimum in the years.
val yearmaxs = yeardf.select($"Year",$"High").groupBy("Year").max()
// The maximum of the column "High" per year was returned.
val res = yearmaxs.select($"Year",$"max(High)")
res.orderBy("Year").show()

// e) What is the average of the "Close" column for each calendar month?
// The column "Month" of the data "Date" was added, in the variable "monthdf".
val monthdf = NetDF.withColumn("Month",month(NetDF("Date")))
// The month and the average of "Close" were selected from the variable "monthdf".
val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()
// The average of the "Close" column for each calendar month was selected and displayed.
monthavgs.select($"Month",$"avg(Close)").orderBy("Month").show()
