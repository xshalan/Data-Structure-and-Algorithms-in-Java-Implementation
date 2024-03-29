## Chapter6: Trees

# Notes
### Tree: 
"**nonlinear data structure**" /_not arranged in sequence_/.
A tree **_T_** is a set of nodes storing elements such that the nodes have a **parent-child** relationship.
![Tree data structure](https://miro.medium.com/max/975/1*PWJiwTxRdQy8A_Y0hAv5Eg.png)
(Image source: [# 8 Useful Tree Data Structures Worth Knowing](https://towardsdatascience.com/8-useful-tree-data-structures-worth-knowing-8532c7231e8c))
1. **root** node has no parent. 
2. every node with parent _w_ is a **child** of _w_
3. Two nodes that are children of the same parent are **siblings**. 
4. A node _v_ is **external**//_leaves_// if has no children.
5. A node _v_ is **internal** if has one or more children.
6. A node _u_ is an **ancestor** of a node _v_ if _u_ is **ancestor** of the parent of _v_. 
7. conversely, a node _v_ is a **descendent** of a node _u_ if _u_ is **ancestor** of node _v_.
**Edge**: A pair of nodes (_u_,_v_) where u is the parent of v, or vice versa.
**Path**: A sequence of nodes. 

#### Ordered Tree: A tree is ordered if there is a linear ordering defined for the children of each node.  

#### Depth of node: is the number of ancestors of the node excluding the node itself.
1. if the node is the root, then the depth is 0. 
2. otherwise, the depth of node is one plus the depth of the parent of that node.
```
depth(T,v):
    if v is the root of T then:
        return 0 
    else
        return 1+depth(T,v.parent())
```

#### Height of node: is the number of ancestors of the node excluding the node itself.
1. if the node is **external**(_has no children_), then the height is 0.
2. otherwise, the height is one plus the maximum height of a child of that node.
```
height(T,v):
    if v is external node in T then:
        return 0 
    else
        h <-- 0
        for each child of v in T do:
            h = max(h, height(T,child))
        return 1+h
```

### Traversal Algorithms: 
#### PreOrder Traversal: systematic way to access or "visit" all nodes of tree T.
1. **Root** is visited **FIRST**. 
2. Then the **subtrees** rooted.
3. Then the **children** of subtrees.

#### PostOrder Traversal: opposite of preorder. **The name comes from** the fact that this traversal method will **visit a node v after** it has visited all other nodes in the subtree rooted at v.
1. **Recursively**, the **children** of subtrees **FIRST**.
2. Then the **subtrees** rooted.
3. Then the **root**.
4. Run in LINEAR time. O(n) where n is the number of visited nodes.
![Tree height vs tree depth](/assets/Height_vs_Depth.png)

(Image Source: [Stackoverflow: What is the difference between tree depth and height?](https://stackoverflow.com/questions/2603692/what-is-the-difference-between-tree-depth-and-height))
### Binary Tree: 
is an ordered tree with the following:
1. Every node have at most two children. 
2. Each child node maybe a left-child or right-child. 
#### Implement binary-tree using linked list. 
![Implementation of binary tree using linked-list](/assets/binary_tree_linkedlist.png)

#### Running-Time Analysis
![binary-tree time analysis](/assets/binary-tree-time-analysis.png)

### Breadth-First Tree Traversal
1. In the breadth-first, we visit all the positions at depth d before we visit the positions at depth d+1.
2.  The process is **not recursive**, since we are not traversing entire subtrees at once.
3. Initialize queue Q to contain root() 
4. while Q not empty do: 
      p = Q.dequeue()
      perform the visit action for position p 
      for each child in p.children():
            Q.enqueue(child)

### Applications of Tree Traversals
1. #### Table of Contents ( hierarchical structure of a document). 
   We need to visit the root first, which is the main chapter in our case, so a **preorder traversal** of the tree can be used to produce a table of content for the document.
2. #### Computing Disk Space
   We need to compute the space of all files inside specific directory, So we used **postorder traversal** algorithm. _Unfortunately_, The formal postorder traversal dose not suffice for compute disk space because the parent have to know about all space of its children(files). 
    ```
   diskSpace(Tree T,Position P):
        subtotal = p.space() // assuming _space()_ return the space of position.
        for each child in T.children(p):
            subtotal += child.space()
   return subtotal
   ```