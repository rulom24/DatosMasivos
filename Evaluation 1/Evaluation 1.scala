//1. Sign in to Spark.
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
val spark = SparkSession.builder().getOrCreate()

//2.Load Netflix Stock CSV.
val NetDF = spark.read.option("header", "true")
            .option("inferSchema", "true")
            csv("C:\\Users\\brise\\Documents\\GitHub\\DatosMasivos\\Evaluation 1\\Netflix_2011_2016.csv")

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

//8.What day had the highest peak in the "close" column?
// Answer: There is no such column in the data frame.

val NetDF2 = df.withColumn("HV Ratio",df("High")/df("Volume"))
df2.show()

//9. What is the meaning of the Close column "Close"?
// Answer: It is the end of the month.

//10. What is the maximum and minimum of the column "Volume"?
df.select(max("Volume")).show()
df.select(min("Volume")).show()
