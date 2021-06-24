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


# Index

1. [Introducción](#id1)
2. [Marco teórico](#id2)
3. [Implementación](#id3)
4. [Resultados](#id4)
5. [Conclusiones](#id5)
6. [Referencias](#id6)

# Introducción<a name="id1"></a>

Este documento tiene la finalidad de dar una breve explicación acerca de diferentes algoritmos de machine learning, SVM (Support Vector Machine), decision tree, logistic regression y multilayer perceptron. A su vez, su objetivo es comparar la eficacia y el rendimiento de estos cuatro algoritmos al probarlos con conjuntos de datos y compilarlos varias veces para observar su comportamiento y sacar nuestras propias conclusiones en base a los resultados arrojados.

# Marco teórico<a name="id2"></a>

### SupportVectorMachine
Una máquina de vectores de soporte (SVM) es un algoritmo de aprendizaje supervisado que se utiliza para muchos problemas de clasificación y regresión, incluidas aplicaciones médicas de procesamiento de señales, procesamiento de lenguaje natural y reconocimiento de voz e imágenes.

El objetivo del algoritmo SVM es encontrar un hiperplano que en la mejor medida posible separe los puntos de datos de una clase de los de la otra, para separar dos clases de datos hay muchos hiperplanos posibles. El objetivo del algoritmo es encontrar el que esté a mayor distancia entre los datos de ambas clases.

(Imagen)

Para obtener el plano más alejado de los dos conjuntos de clases se tiene que calcular la distancia perpendicular de cada observación a un determinado hiperplano. La menor de estas distancias (conocida como margen) determina como de alejado está el hiperplano de las observaciones de entrenamiento.

(Imagen)

Los puntos que se encuentran en las fronteras de los márgenes son conocidos como vectores de soporte, SVM busca maximizar el margen entre los puntos y el hiperplano.

#### Tipos
La función matemática utilizada para la transformación se conoce como función kernel. Por lo regular admiten:
- Lineal
- Polinómico
- Función de base radial (RBF)
- Sigmoide

#### Ventajas
Los clasificadores de Máquinas de Vectores de Soporte ofrecen una buena precisión y realizan predicciones más rápidas en comparación con el algoritmo de Naive Bayes. También utilizan menos memoria porque utilizan un subconjunto de puntos de entrenamiento en la fase de decisión. Este algoritmo funciona bien con un claro margen de separación y con un espacio dimensional elevado.

#### Desventajas
Las Máquinas de Vectores de Soporte no son adecuadas para grandes conjuntos de datos debido a su alto tiempo de formación y también requiere más tiempo de formación en comparación con Naive Bayes. Funciona mal con clases superpuestas y también es sensible al tipo de núcleo utilizado.

### Decision Tree
Los árboles de decisión son un método de aprendizaje supervisado no paramétrico que se utiliza para la clasificación y regresión. El objetivo es crear un modelo que prediga el valor de una variable objetivo mediante el aprendizaje de reglas de decisión simples inferidas de las características de los datos. Un árbol puede verse como una aproximación constante a trozos.

En el ejemplo siguiente, los árboles de decisión aprenden de los datos para aproximar una curva sinusoidal con un conjunto de reglas de decisión si-entonces-si no. Cuanto más profundo es el árbol, más complejas son las reglas de decisión y más ajustado es el modelo.

(Imagen)

Los tipos de árboles de decisión se basan en el tipo de variable objetivo que tenemos. Puede ser de dos tipos:
1. Árbol de decisión de variable categórica: árbol de  decisión que tiene una variable objetivo categórica y luego se llama  árbol de decisión de variable categórica.
2. Árbol de decisión de variable continua: El árbol de  decisión tiene una variable de destino continua, por lo que se denomina  Árbol de decisión de variable continua.

Algunas ventajas de los árboles de decisión son:
- Sencillo de entender e interpretar. Los árboles se pueden visualizar.
- Requiere poca preparación de datos. Otras técnicas a menudo requieren la normalización de datos, es necesario crear variables ficticias y eliminar valores en blanco. Sin embargo, tenga en cuenta que este módulo no admite valores perdidos.
- El costo de usar el árbol (es decir, predecir datos) es logarítmico en el número de puntos de datos usados ​​para entrenar el árbol.

Las desventajas de los árboles de decisión incluyen:
- Los aprendices de árboles de decisión pueden crear árboles demasiado complejos que no generalizan bien los datos. A esto se le llama sobreajuste. Mecanismos como la poda, el establecimiento del número mínimo de muestras necesarias en un nodo de la hoja o el establecimiento de la profundidad máxima del árbol son necesarios para evitar este problema.
- Los árboles de decisión pueden ser inestables porque pequeñas variaciones en los datos pueden resultar en la generación de un árbol completamente diferente. Este problema se mitiga mediante el uso de árboles de decisión dentro de un conjunto.
- Las predicciones de los árboles de decisión no son uniformes ni continuos, sino aproximaciones constantes por partes, como se ve en la figura anterior. Por lo tanto, no son buenos para la extrapolación.

### Logistic Regression
La regresión logística es un algoritmo de modelado predictivo que se utiliza cuando la variable Y es categórica binaria. Es decir, solo puede tomar dos valores como 1 o 0. El objetivo es determinar una ecuación matemática que se puede usar para predecir la probabilidad del evento 1. Una vez que se establece la ecuación, se puede usar para predecir la Y cuando solo las X son conocidas.

En la regresión lineal, la variable Y es siempre una variable continua. Si suponga que la variable Y es categórica, no puede usarla como modelo de regresión lineal.
Cuando Y es una variable categórica con 2 clases, la regresión logística se puede utilizar para modelar y resolver estos problemas, también llamados problemas de clasificación binaria.

Un punto clave a tener en cuenta aquí es que Y solo puede tener 2 clases y no más que eso. Si Y tiene más de 2 clases, se convertiría en una clasificación de clases múltiples y ya no puede usar la regresión logística de vainilla para eso.

Sin embargo, la regresión logística es una técnica clásica de modelado predictivo y sigue siendo una opción popular para modelar variables categóricas binarias.

Otra ventaja de la regresión logística es que calcula una puntuación de probabilidad de predicción de un evento. Más sobre eso cuando empieces a construir los modelos.

(Imagen)

Comparando con la regresión lineal, cuando la variable de respuesta tiene solo 2 valores posibles, es deseable tener un modelo que prediga el valor como 0 o 1 o como una puntuación de probabilidad que oscile entre 0 y 1.

La regresión lineal no tiene esta capacidad. Porque, si utiliza la regresión lineal para modelar una variable de respuesta binaria, es posible que el modelo resultante no restrinja los valores de Y predichos entre 0 y 1.

### Multilayer perceptron

Un perceptrón multicapa (MLP) es una clase de red neuronal artificial de retroalimentación

El perceptrón es muy útil para clasificar conjuntos de datos que son linealmente separables. Se encuentran con serias limitaciones con conjuntos de datos que no se ajustan a este patrón como se descubrió con el problema XOR. El problema XOR muestra que para cualquier clasificación de cuatro puntos existe un conjunto que no es separable linealmente.

MultiLayer Perceptron (MLP) rompe esta restricción y clasifica conjuntos de datos que no son separables linealmente. Lo hacen utilizando una arquitectura más robusta y compleja para aprender modelos de regresión y clasificación para conjuntos de datos difíciles.

El Perceptrón consta de una capa de entrada y una capa de salida que están completamente conectadas. Los MLP tienen las mismas capas de entrada y salida, pero pueden tener múltiples capas ocultas entre las capas mencionadas anteriormente, como se ve a continuación.

(Imagen)

- La capa de entrada consta de neuronas que aceptan los valores de entrada. La salida de estas neuronas es la misma que la de los predictores de entrada. Los nodos de la capa de entrada representan los datos de entrada. Todos los demás nodos asignan entradas a salidas mediante una combinación lineal de las entradas con los pesos de los nodos w y el sesgo aplicando una función de activación. Esto se puede escribir en forma de matriz para MLPC con capas K + 1 de la siguiente manera: Input_Layer
- Las capas ocultas se encuentran entre las capas de entrada y salida. Normalmente, el número de capas ocultas varía de una a muchas. Es la capa de cálculo central que tiene las funciones que mapean la entrada a la salida de un nodo. Los nodos de las capas intermedias utilizan la función sigmoidea (logística), como sigue Hidden_Layer
- La capa de salida es la capa final de una red neuronal que devuelve el resultado al entorno del usuario. Basado en el diseño de una red neuronal, también indica a las capas anteriores cómo se han desempeñado en el aprendizaje de la información y, en consecuencia, mejoraron sus funciones. Los nodos de la capa de salida utilizan la función softmax. Output_Layer

El número de nodos N, en la capa de salida, corresponde al número de clases.

# Implementación<a name="id3"></a>

Se decidió hacer uso del lenguaje spark para este proyecto debido a su gran versatilidad a la hora de manipular grandes cantidades de datos, logrando analizarlos en un tiempo bastante bueno de una manera eficaz y eficiente para la obtención de nuestros resultados.

Los 4 algoritmos fueron realizados en Spark con Scala, ya que fue el lenguaje que se utilizó a lo largo de la materia, así cómo por su eficiencia al momento de realizar las pruebas ya que gasta solo los recursos necesarios para ejecutar toda la información.

### SVM
```{r}
// Import libraries
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.log4j._

//Minimize errors
Logger.getLogger("org").setLevel(Level.ERROR)

//Define val on runtime and startTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//Start a session in spark
val spark = SparkSession.builder.appName("LinearSVCExample").getOrCreate()

//The data is loaded into the variable "data" in the format "bank_full.csv"
val training = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")
val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(training)
val indexed = labelIndexer.transform(training).drop("y").withColumnRenamed("indexedLabel", "label")

//Generate a vector with the names of the columns to evaluate
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Define the vectorFeatures object to transform vectorFeatures.transform(newDF)
val features = vectorFeatures.transform(indexed)

//Rename the column ("y" , Label)
val featuresLabel = features.withColumnRenamed("y", "label")

//Index the label and features columns
val dataIndexed = featuresLabel.select("label","features")

//Index the labels
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(dataIndexed)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(dataIndexed)

//Divide the data, 70% training and 30% testing
val Array(training, test) = dataIndexed.randomSplit(Array(0.7, 0.3), seed = 12345)

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

//Define model training data 70%
val lsvcModel = lsvc.fit(training)

//Define results training data 30%
val results = lsvcModel.transform(test)


val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

//Print Accuracy
println("Accuracy: " + metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
```

### Decision Tree
```{r}
//Import libraries
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer 
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.log4j._

//Minimize errors
Logger.getLogger("org").setLevel(Level.ERROR)

//Define val on runtime and startTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//Start a session in spark
val spark = SparkSession.builder.appName("DecisionTreeClassificationExample").getOrCreate()

//The data is loaded into the variable "data" in the format "bank_full.csv"
val data  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter",";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")

//Generate vector with the names of the columns to evaluate
val vectorFeatures = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Define the vectorFeatures object to transform vectorFeatures.transform(newDF)
val features = vectorFeatures.transform(data)

//Rename the column ("y", lable)
val featuresLabel = features.withColumnRenamed("y", "label")

//Index the labels
val dataIndexed = featuresLabel.select("label","features")
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(dataIndexed)
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(dataIndexed) // features with > 4 distinct values are treated as continuous.

//Divide the data, 70% training and 30% testing
val Array(trainingData, testData) = dataIndexed.randomSplit(Array(0.7, 0.3))

//Define the model for the decision tree
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
val model = pipeline.fit(trainingData)
val predictions = model.transform(testData)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

//Print Accuracy
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
```

### Logistic Regression
```{r}
//Import libraries 
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.log4j._

//Minimize errors
val spark = SparkSession.builder().getOrCreate()

//Define val on runtime and startTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//The data is loaded into the variable "data" in the format "bank_full.csv"
val data  = spark.read.option("header","true").option("inferSchema","true").option("delimiter", ";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")

//Rename the column ("y", lable)
val label = new StringIndexer().setInputCol("y").setOutputCol("label")
val labeltransform = label.fit(data).transform(data)

//Generate vector with the names of the columns to evaluate
val assembler = new VectorAssembler().setInputCols (Array ("balance", "day", "duration", "pdays", "previous")).setOutputCol("features")

//Define the assembler object to transform assembler.transform(newDF)
val data2 = assembler.transform(labeltransform)

//Index the labels
val training = data2.select("features", "label")

//Divide the data, 70%-30%
val splits = training.randomSplit(Array(0.7, 0.3), seed = 12345)

//Define 70% training and 30% testing
val train = splits(0)
val test = splits(1)

//Define the model for Logistic Regression
val lr = new  LogisticRegression().setMaxIter(10).setRegParam(0.1)
val model = lr.fit(train)
val result = model.transform(test)

val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print Accuracy
println(s"Accuraccy = ${evaluator.evaluate(result)}")
println(s"Test Error = ${(1.0 - (evaluator.evaluate(result)))}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
```

### Multilayer Perceptron
```{r}
//Import libraries
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

//Define val on runtime and starTimeMillis
val runtime = Runtime.getRuntime
val startTimeMillis = System.currentTimeMillis()

//The data is loaded int the variable "datos"
val data = spark.read.option("header","true").option("inferSchema","true").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")
datosBank.show() 
val data = spark.read.option("header","true").option("inferSchema","true").option("delimiter",";").format("csv").load("C:/Users/brise/Documents/GitHub/DatosMasivos/Project/bank-full.csv")
val changes1 = data.withColumn("y",when(col("y").equalTo("yes"),1).otherwise(col("y")))
val changes2 = changes1.withColumn("y",when(col("y").equalTo("no"),2).otherwise(col("y")))
val newColumn = changes2.withColumn("y",'y.cast("Int"))

//Generate vector with the names of the columns to evaluate
val assembler = (new VectorAssembler().setInputCols(Array("balance","day","duration","pdays","previous")).setOutputCol("features"))

//Define the assembler object to transform assembler.transform(newDF)
val Ldata = assembler.transform(newColumn)

//Rename the column ("y", lable)
val changes = Ldata.withColumnRenamed("y", "label")
val feat = changes.select("label","features") 

//Divide the data, 70%-30%
val splits = feat.randomSplit(Array(0.7, 0.3), seed = 1234L)

//Define 70% training and 30% testing
val train = splits(0)
val test = splits(1)

//Define the model for Multilayer perceptron
val LayersN = Array[Int](5, 6, 3, 4)
val training = new MultilayerPerceptronClassifier().setLayers(LayersN).setBlockSize(128).setSeed(1234L).setMaxIter(100)
val model = training.fit(train)

val resultados = model.transform(test)
val predictionAndLabels = resultados.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

//Print Accuracy
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
println(s"Test Error = ${(1.0 - (evaluator.evaluate(predictionAndLabels)))}")

//Print RunTime
val endTimeMillis = System.currentTimeMillis()
val durationSeconds = (endTimeMillis - startTimeMillis) / 1000
```

# Resultados<a name="id4"></a>
### SVM
Al realizar las 30 pruebas del algoritmo SVM podemos ver una constante en cada evaluación, en donde todas las pruebas nos lanza cómo resultado una precisión del 88.55%, lo que suele variar es el tiempo de ejecución, pero hablamos de 1 segundo a lo mucho entre cada prueba teniendo un promedio de 11.27 segundos.

|Reiteración |Precisión |Margen de error |Tiempo de ejecución |
|---------|---------|---------|---------|
|1|0.8855|0.1145|12|
|2|0.8855|0.1145|12|
|3|0.8855|0.1145|11|
|4|0.8855|0.1145|12|
|5|0.8855|0.1145|11|
|6|0.8855|0.1145|11|
|7|0.8855|0.1145|11|
|8|0.8855|0.1145|11|
|9|0.8855|0.1145|11|
|10|0.8855|0.1145|11|
|11|0.8855|0.1145|11|
|12|0.8855|0.1145|11|
|13|0.8855|0.1145|11|
|14|0.8855|0.1145|11|
|15|0.8855|0.1145|11|
|16|0.8855|0.1145|13|
|17|0.8855|0.1145|11|
|18|0.8855|0.1145|11|
|19|0.8855|0.1145|11|
|20|0.8855|0.1145|11|
|21|0.8855|0.1145|11|
|22|0.8855|0.1145|11|
|23|0.8855|0.1145|11|
|24|0.8855|0.1145|12|
|25|0.8855|0.1145|11|
|26|0.8855|0.1145|11|
|27|0.8855|0.1145|12|
|28|0.8855|0.1145|12|
|29|0.8855|0.1145|11|
|30|0.8855|0.1145|11|

### Decision Tree
En la prueba de árboles de decisión podemos ver una variación en la precisión en cada reiteración, pero siempre en un mismo rango de menos del 1% de precisión con un promedio del 89.20%, a comparación del algoritmo anterior, aquí podemos ver que en la primer prueba se demoró más del doble que el resto, puede ser que al tener un algoritmo nuevo, se re-escribe la caché y por eso la segunda prueba ya lo hace mas rapido. En tiempo tenemos un promedio de 6.34 segundos.

|Reiteración|Precisión|Margen de error|Tiempo de ejecución|
|---------|---------|---------|---------|
|1|0.8938|0.1062|15|
|2|0.8917|0.1083|7|
|3|0.8923|0.1077|7|
|4|0.8911|0.1089|6|
|5|0.895|0.105|6|
|6|0.8941|0.1059|6|
|7|0.8937|0.1063|6|
|8|0.8937|0.1063|6|
|9|0.8891|0.1109|6|
|10|0.8909|0.1091|6|
|11|0.8959|0.1041|6|
|12|0.8882|0.1118|6|
|13|0.8953|0.1047|6|
|14|0.893|0.107|6|
|15|0.8883|0.1117|6|
|16|0.8927|0.1073|6|
|17|0.893|0.107|6|
|18|0.8922|0.1078|6|
|19|0.8877|0.1123|6|
|20|0.8903|0.1097|5|
|21|0.8933|0.1067|6|
|22|0.8911|0.1089|6|
|23|0.8918|0.1082|6|
|24|0.8886|0.1114|6|
|25|0.8901|0.1099|6|
|26|0.8901|0.1099|6|
|27|0.8959|0.1041|6|
|28|0.8941|0.1059|6|
|29|0.8917|0.1083|6|
|30|0.8918|0.1082|6|

### Logistic Regression
En esta prueba tenemos el mismo caso de estabilidad que la prueba de SVM al tener una constante de 88.53% de precisión e igual que en el árbol de decisión, tenemos el caso del tiempo con la primer prueba con casi el triple de tiempo promedio del resto, teniendo un promedio total de 5.4 segundos.

|Reiteración|Precisión|Margen de error|Tiempo de ejecución|
|---------|---------|---------|---------|
|1|0.8853|0.1147|15|
|2|0.8853|0.1147|6|
|3|0.8853|0.1147|6|
|4|0.8853|0.1147|5|
|5|0.8853|0.1147|5|
|6|0.8853|0.1147|5|
|7|0.8853|0.1147|5|
|8|0.8853|0.1147|5|
|9|0.8853|0.1147|5|
|10|0.8853|0.1147|5|
|11|0.8853|0.1147|5|
|12|0.8853|0.1147|5|
|13|0.8853|0.1147|5|
|14|0.8853|0.1147|5|
|15|0.8853|0.1147|5|
|16|0.8853|0.1147|5|
|17|0.8853|0.1147|5|
|18|0.8853|0.1147|5|
|19|0.8853|0.1147|5|
|20|0.8853|0.1147|5|
|21|0.8853|0.1147|5|
|22|0.8853|0.1147|5|
|23|0.8853|0.1147|5|
|24|0.8853|0.1147|5|
|25|0.8853|0.1147|5|
|26|0.8853|0.1147|5|
|27|0.8853|0.1147|5|
|28|0.8853|0.1147|5|
|29|0.8853|0.1147|5|
|30|0.8853|0.1147|5|

### Multilayer perceptron
El algoritmo de perceptrón multicapa fue el segundo más preciso en todas las pruebas realizadas con una constante del 88.63% en todas las pruebas, pero fue el más tardado de todos, teniendo la primer prueba 24 segundos y un promedio de 13.44 segundos.

|Reiteración|Precisión|Margen de error|Tiempo de ejecución|
|---------|---------|---------|---------|
|1|0.8863|0.1137|24|
|2|0.8863|0.1137|15|
|3|0.8863|0.1137|13|
|4|0.8863|0.1137|13|
|5|0.8863|0.1137|13|
|6|0.8863|0.1137|13|
|7|0.8863|0.1137|13|
|8|0.8863|0.1137|13|
|9|0.8863|0.1137|13|
|10|0.8863|0.1137|13|
|11|0.8863|0.1137|13|
|12|0.8863|0.1137|13|
|13|0.8863|0.1137|13|
|14|0.8863|0.1137|13|
|15|0.8863|0.1137|13|
|16|0.8863|0.1137|13|
|17|0.8863|0.1137|13|
|18|0.8863|0.1137|13|
|19|0.8863|0.1137|13|
|20|0.8863|0.1137|13|
|21|0.8863|0.1137|13|
|22|0.8863|0.1137|13|
|23|0.8863|0.1137|13|
|24|0.8863|0.1137|13|
|25|0.8863|0.1137|13|
|26|0.8863|0.1137|13|
|27|0.8863|0.1137|13|
|28|0.8863|0.1137|13|
|29|0.8863|0.1137|13|
|30|0.8863|0.1137|13|

# Conclusiones<a name="id5"></a>

#### Raúl Omar Briseño Cota: 
Durante las pruebas de los diferentes algoritmos pudimos observar en lo que destaca cada algoritmo, alguno más rápido, otro más preciso, todos con sus respectivas variantes, pero a su vez con una gran eficiencia en relación al tiempo de ejecución.

#### Juan Antonio  Aceves Zamora: 
Gracias a este trabajo he aprendido a desarrollar de una manera más amplia mis conocimientos en esta materia para aplicarlos a problemas de la vida real como la obtención de datos, limpiarlos y optimizarlos para obtener los resultados demandados de una manera más eficiente y eficaz. 

# Referencias<a name="id6"></a>
#### SVM
http://stening.blog/clasificacion-de-dispositivo-medico-utilizando-diferentes-tecnicas-de-machine-learning/

https://programmerclick.com/article/18211343732/

https://www.mathworks.com/discovery/support-vector-machine.html

https://www.ibm.com/docs/es/spss-modeler/SaaS?topic=models-how-svm-works

#### Decision tree
https://www.kdnuggets.com/2020/01/decision-tree-algorithm-explained.html
https://scikit-learn.org/stable/modules/tree.html

#### Logistic Regression
https://www.cienciadedatos.net/documentos/27_regresion_logistica_simple_y_multiple
https://www.machinelearningplus.com/machine-learning/logistic-regression-tutorial-examples-r/#h-1-introduction-to-logistic-regression
https://spark.apache.org/docs/latest/ml-classification-regression.html#logistic-regression

https://spark.apache.org/docs/latest/
https://www.scala-lang.org/

#### Multilayer perceptron
https://medium.com/data-science-bootcamp/multilayer-perceptron-mlp-vs-convolutional-neural-network-in-deep-learning-c890f487a8f1
