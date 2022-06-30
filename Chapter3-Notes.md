## Chapter3: Indices, Nodes and Recursion

# Notes

### Insertion sort
1. Insertion sort split array into two arrays, one sorted and the other one is unsorted. 
for example: [4,5, | 1,2] take current unsorted item ( 1 ) and go left **until insert it in the correct place**
2. If the array is already sorted, the inner loop (while) do only one comparison without needing to swap.

### Pseudo-Random Generation 
`Numbers that are statistically random. These sequences are not actually random, however it is possible to predict the next number from the current number according to the formula (in Java syntax):
next = (a*cur+b)%n; ` <br>
Since the next number in generator is determined by the previous number which is called `seed`. So it's good practice to 
have different sequence each time as a seed. That's why we use system current time as seed: 
```java
Random rand = new Random(System.currentTimeMillis());
```

### Simple Cryptography with Chars array
Another application of arrays is the representing of strings of characters.

#### Caesar Cipher
Encrypt and decrypt plaintext by replace each letter with another fixed-offset letter. e.g replace A with D, B with E etc.. 

*  Modulus is the concept of REMINDER. In other words, we can define a range using modulus. In our case we only have 26 alphabet so 65('A') mod 65 = 0 which is first letter in our list. 90('Z) mod 65 = 25 which is last letter in our list.

### Two dimensional Arrays. 
1. Two dimensional Arrays are really one dimensional array nested inside a common one-dimensional array. (compound object). 
2. Arrays.equal(A,B) ==> do `Shallow Equality` but in case two 2-D arrays have the same content it will be false.
```java
int[][] A= {{4,18},{29,35}};
int[][] B= {{4,18},{29,35}};
System.out.println(Arrays.equals(A,B)); // false;
```
That is because int[][] is an `instanceof` `Object[]` not `int[]` . This simple equality rule says that two base type variables are equal if they have the same value and refer to the same object. 
3. `deepEquals(A,B)` => used to test if two arrays are deeply equal.
4. In general, Arrays are **not very adaptable** (fixed size)
### Singly Linked Lists
1. A Sequence of elements(Nodes) connecting together in linear order. 
2. The next reference inside a node is a pointer to the next node. Knowing as `link/pointer hopping`
3. We can't remove node at the tail position because we don't have reference to the previous one.
4. {head}-> **| Node A |** ---> **| Node B |** ---> **| Node C |** <- {tail}

#### insert element at first 
```
addFirst(node):
node.setNext(head)
head <- head
size <- size+1
```

#### insert element at tail
```
addLast(node):
node.setNext(null)
tail.setNext(node)
tail <- node
size <- size+1
```

#### Remove element at head: 
```
removeFirst():
temp <= head 
head <= head.getNext()
temp.setNext(null)
size <= size -1
```