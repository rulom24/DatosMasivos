<h1>Tecnológico Nacional de México</h1>
<h5 style="text-align: center;"> Instituto Tecnológico de Tijuana 

Subdirección Académica 
Departamento de Sistemas y Computación 

Semestre: Febrero - Junio 2021

Materia:
Datos Masivos

Profesor: 
Jose Christian Romero Hernandez

Alumno: 
16210502 Aceves Zamora Juan Antonio
13211397 Briseño Cota Raúl Omar


 </h5>


### Index

1. [Evaluation 3](#id1)


# Evaluation 3<a name="id1"></a>

### //1.- Import libraries.
```{r}
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.log4j._
```

### //2.- Minimize errors.
```{r}
Logger.getLogger("org").setLevel(Level.ERROR)
```

### //3.-Create spark session.
```{r}
val spark = SparkSession.builder.getOrCreate()
```

### //4.- Load dataframe.
```{r}
val dataf = spark.read.option("header", "true").option("inferSchema","true")csv("C:/Users/brise/Documents/GitHub/DatosMasivos/Evaluation/Wholesale_customers_data.csv")
```


### //5.- We select the columns with which we are going to work
```{r}
val feature_data = dataf.select ("Fresh", "Milk", "Supermarket", "Frozen", "Detergents_Paper", "Delicassen")
feature_data.show
```

![one image](https://github.com/rulom24/DatosMasivos/blob/Unit-3/Evaluation/Captura1.png)



### //9.- We evaluate the groups.
```{r}
val WSSSE = model.computeCost(features)
println(s"Within set sum of Squared Errors = $WSSSE")
```

![two image](https://github.com/rulom24/DatosMasivos/blob/Unit-3/Evaluation/Captura2.png)


### //10.- We print the results.
```{r}
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```

![three image](https://github.com/rulom24/DatosMasivos/blob/Unit-3/Evaluation/Captura3.png)
