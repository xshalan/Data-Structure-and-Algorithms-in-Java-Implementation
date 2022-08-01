## Chapter6: List and Iterator ADTs

# Notes

### ArrayLists 
is a list or sequence of elements. we refer to each element in the list _S_ using an integer in the range [0,n-1]
where n is the number of elements in the list.
1. We can insert element in specific `index`
2. Insert or delete elements requires shifting of elements up or down to maintian the rule of storing element in index _i_ in the list. 
3. Performance of array-based list is: 
   |Method|Time  |
   |--|--|
   | size() |_O_(1)  |
   | get(index) |_O_(1)  |
   | set(index,element) |_O_(1)  |
   | add(index,element) |_O_(n)  |
   | remove(index,element) |_O_(n)  |
4. Array is a fixed-size data structure. To overcome that weakness, we use a technique called `extendable-array` which is, when **overflow** occurs, perform the following steps:
   1. Allocating new Array B with size 2*N.
   2. copy all elements to the new array.
   3. Let A <-- B 
5. Analysis the algorithm for `extendable-array` :
   1. For the first sight, we can say that our performance is `slow` because some element insertion can take _O_(N) time.
   2. However, the array-list is efficient in terms of its total running time. for example:
      ![Array list analysis of insertion time](/assets/arraylist-analysis.png)
   The analysis is done using `Amortized Analysis` which refers to the averaged running time for a sequence of operations. (unlike **average case analysis** which analyze individual operations   )
   3. "Amortized analysis generally applies to a method that consists of a sequence of operations, where the vast majority of the operations are cheap, but some of the operations are expensive." [Source](https://www.cs.cornell.edu/courses/cs3110/)