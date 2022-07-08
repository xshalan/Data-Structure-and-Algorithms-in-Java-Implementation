## Chapter4: Analysis Tools

# Notes
### Seven types of functions
#### 1. Constant function
$f(n) = c$
1. for any value of $n$ the result is always equal to the constant value $c$
2. It's useful because it represents the number of steps needed to do an operation e.g Adding two numbers, comparing two numbers etc.

#### 2. Logarithm function
$x = log_ba$
**How many of  _one number_ `b`  multiply together `x` to make  _another number`a`?_**
e.g:
$log_264=6$ that mean $2󫎾󫎾�2=64$
In CS: **$log_{}n=log_{2}n$**
- Log is the inverse of exponent => $b^x$
- the rate changes at increasing pace. 10,100,10000,1000000 etc.
- Logarithm rules => useful for approximation while analysis an algorithm.
    -	$log_bac=log_ba+log_bc$
    -	$log_ba/c=log_ba-log_bc$
    -	$log_ba^c=c log_ba$
    -	$d^{log_ba}=a^{log_bd}$
- Examples:

    -	$log_{}2n=log{}2+log_{}n=1+logn$
    -	$log_{}n/2=log_{}n-log_{}2=logn-1$
    -	$log_{}n^3=3 log_{}n$
    -	$2^{log_{}n}=n^{log_{}2=n^1=n}$

#### 3. Linear Function
$f(n)=n$
1. Take `n` time in terms of processing `n` objects.
2. Arises when we have to do a single basic operation for each of `n` elements.

#### 4. N-Log-N Function
$f(n)=nlogn$
1. Linear function scaled by $logn$
2. Slower than the liner function ![Linear function vs N-Log-N function](/assets/n-vs-nlogn.png)

#### 5. Quadratic Function
$f(n)=n^2$
1. the function $f$ assigns the product of $n$ with itself.
2. Nested loop for example-> inner loop performs a linear number of operations and outer loop is performed a linear number of times. Thus $n.n=n^2$

#### 6. Cubic Function
$f(n)=n^3$

#### 7. Exponential Function
$f(n)=b^n$
1. the function $f$ assigns to the input `n` by product the base `b` by itself `n` times.
2. For example, `b=2` if loop starts by performing one operation and then doubles the numbers of operations with each iteration. Then the number of operations performed in $nth$ is $2^n$

### Analysis of Algorithms
#### Primitive Operations:
1. Assign a value to a variable
2. Calling a method
3. perform arithmetic operation
4. comparing two numbers
5. indexing into array
   Primitive operations corresponds to low-level instruction with an `execution time that is constant` So we're trying to determine the specific execution time of each primitive operation. So simply we will **count** how many primitive operations are executed?.
* This number will be **proportional** to the actual running time of an algorithm.
#### Asymptotic Notation
Instead of COUNT the executed operations, we focus on the **big picture**.
1. we focus on the growth rate of the running time as a function of the input size `n`.

##### Big-Oh Notation O(n)
 
