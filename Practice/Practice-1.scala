//We start with this library to have access to local matrices and Factory Methods for Vectors.
import org.apache.spark.ml.linalg.{Matrix, Vectors}
//libreria para usar el método de correlación
import org.apache.spark.ml.stat.Correlation
//It allows access to a value in a row through generic access by ordinal, as well as primitive access.
import org.apache.spark.sql.Row

//Crea vectores densos y dispersos  a partir de sus valores, dentro de la matriz 
val data = Seq(
   (4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)

//The data is extracted from our matrix and a dataframe is created regarding the characteristics.
val df = data.map(Tuple1.apply).toDF("features")
//The DE Pearson correlation matrix is ​​created using the data frame that we just created and we ask for the first values ​​with head.
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
//we print the result.
println(s"Pearson correlation matrix:\n $coeff1")
//The Spearman correlation matrix is ​​created using the dataframe that we just created and we ask for the first values ​​with head.
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
//We print the result.
println(s"Spearman correlation matrix:\n $coeff2")



//Hypothesis testing.


//The following library is used to apply methods to vectors.
import org.apache.spark.ml.linalg.{Vector, Vectors}
//The chiSquare library is also used to perform the necessary calculations.
import org.apache.spark.ml.stat.ChiSquareTest

// The following sequence of dense vectors is created 
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)

//Creation of the dataframe from the previous set of vectors.
val df = data.toDF("label", "features")
//The first values of the previously created data frame are taken.
val chi = ChiSquareTest.test(df, "features", "label").head
//Starting with the parts of the test, the values ​​of p will be searched. 
println(s"pValues = ${chi.getAs[Vector](0)}")
//Then we will look for the degrees of freedom of the model.
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
//Finally, certain values will be extracted from a final vector based on the chi square function.
println(s"statistics ${chi.getAs[Vector](2)}")


//Summarizer

//Import of necessary libraries, in this use of vectors and the summarizer itself.
import spark.implicits._    
import Summarizer._

//A set of vectors or sequence is created.
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)

//Creation of the dataframe from the vectors.
val df = data.toDF("features", "weight")


//The summarizer library is used to obtain the mean and variance of some data in the requested dataframe.
val (meanVal, varianceVal) = df.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()

//The variables previously worked on are printed.
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

//The process is repeated with 2 new variables.
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features"))
  .as[(Vector, Vector)].first()
// Variable printing.
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}"

