## Chapter3: Notes

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