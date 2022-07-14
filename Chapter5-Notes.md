## Chapter4: Stacks, Queues and Deques

# Notes

### Stack 
1. insert and remove according to **last-in-first-out LIFO**
2.  Stack ADT: push-> to insert & pop-> to remove. `first element is the TOP`
3. Every Operation takes `O(1)`
   | Method | Time |   
   |--|--|  
   |size| O(1)|
   |push| O(1)|
   |pop| O(1)|
4. Array-Based is **limited** to the size of the array [CAPACITY]
5. **NodeList** Stack is more efficient regarding SPACE. 

### Queue. 
is the 'cousin' of Stack.  `first element is the FRONT`
1. insert and remove according to **first-in-first-out FIFO** 
2. Queue ADT: enqueue-> to insert & dequeue-> to remove. 