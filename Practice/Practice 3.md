### Elaborate all the algorithms of the fibonacci series with Scala.

#### Fibonacci algorithms

Algorithm-1 Fibonacci Recursive Version


We define the value of "n" with value 20, we create the function fib with a condition, if "n" is not less than 2 it returns the value n, but it returns the function fib. 
At the end we print the result of fib.

val n=20

def fib(n:Int): = Int {

  if(n<2)
  
 {
 
  return n
  
 }
 
  else
  
 {
 
 return fib(n-1) + fib(n-2)
 
 }
 
}

println(fib(n))


Algorithm-2 Version with explicit formula.

This algorithm uses the explicit formula for the fibonacci series, this formula is not as accurate as when using the conventional methods like cycles or recursion.

val n = 10

var phi=((1+math.sqrt(5))/2)

var j=((math.pow(phi,n)-math.pow((1-phi),n))/(math.sqrt(5)))

def fib(n:Double) : Double ={

if (n<2){

return n
           }
           
else {

 	return j
  
        }
}

println(fib(n))


Algorithm-3 Iterative version

We create a function called fib (), which will receive and return an INT, we define 3 variables a = 0, b = 1 and c = 0. We did a for loop, the loop will do 3 things: first add (b + a) to the variable c, then it will give the value of b to the variable and finally it will assign the value of c to the variable b. In the end it will return the result.

def fib(num:Int):Int={

	var a = 0
  
	var b = 1
  
	var c = 0
  
	for(k <- Range(0,num)){
  
    	c = b + a
      
    	a = b
      
    	b = c
      
	}
  
	return a
  
}

fib(10)
fib(20)
fib(30)
