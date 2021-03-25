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
