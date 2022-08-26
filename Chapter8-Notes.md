## Chapter8: Heap and Priority Queue

# Notes

### Priority Queue:

Insert elements in queue by priority via **implementing comparator interface** to compare the inserted element each time
adding new element to the queue.

#### Using List:

we can use _sorted_ list to implement the queue, which produce time complexity as follows:

|  Method   | Time |
|:---------:|:----:|
|   Size    | O(1) |
|  isEmpty  | O(1) |
|  insert   | **O(n)** |
|    min    | O(1) |
| removeMin | O(1) |


#### Heap: 
1. Heap is a binary tree that stores entries at its positions. 
2. a minimal key is always stored at the root of heap. 
3. For the sake of efficiency,heap must be what we term **complete**. 

>we provide a more efficient realization of a priority queue using
a data structure called a binary heap. This data structure allows us to perform both
insertions and removals in **logarithmic time**. 

