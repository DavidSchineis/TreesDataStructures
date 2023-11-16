# Trees Project
>A simple program implemented in Java and completed during my data structures class.
>Processes a tree from a txt file and prints a variety of traversals to the console.

## Input
This program reads a tree structure from a file named tree.txt and displays the tree structure on the console as described below. Each line in the file will hold a node's ID and its children's IDs. For example, if the file contains the following:  
```
1 2 3 4  
3 6  
4 7 8  
```
The first ID in each line represents the parent node and the remaining IDs in that line are its children. In the tree structure above, 1 has three children 2,3,4; node 3's child is 6, and 7 and 8 are children of node 4. Node 2 does not have any child and that's why it is not at the start of any line in the file. Node 1 is the root of the tree always and it will be in the first column of the first line in the file.


## Output
The program will then process and output the tree in the following ways:
* Pre-order traversal
* Post-order traversal
* In-order traversal (if the tree is binary)
* BFS  
