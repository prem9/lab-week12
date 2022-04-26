package com.example;

// node for a binary search tree
class Node {

  int value;
  Node left;
  Node right;
  static final int COUNT = 10;

  // constructor
  Node(int value) {
    this.value = value;
    right = null;
    left = null;
  }

  // getter for the value of the node
  public int value() {
    return value;
  }

  // add a node
  public void add(int newValue) {
    // add to left
    if (newValue < value) {
      if (left == null) {
        left = new Node(newValue);
      } else {
        left.add(newValue);
      }
    }

    // add to right
    if (newValue > value) {
      if (right == null) {
        right = new Node(newValue);
      } else {
        right.add(newValue);
      }
    }
    // if curr.value == newValue, we have already added it, do nothing

  }

  // print, in-order left-node-right (sorted) tree traversal
  private void printInOrder(Node curr) {
    if (curr != null) {
      printInOrder(curr.left);
      System.out.printf("node value = %d\n", curr.value);
      printInOrder(curr.right);
    }
  }

  // print
  public void printInOrder() {
    printInOrder(this);
  }

  // find a value in the tree
  public Node search(int x) {
    if (value == x) {
      return this;
    }

    // search left
    if ((x < value) && (left != null)) {
      return left.search(x);
    }

    // search right
    if ((x > value) && (right != null)) {
      return right.search(x);
    }

    return null;
  }

  // print, reverse order
  // student needs to write code to
  // do a reverse-order traversal of the tree
  public void printReverseOrder(Node curr) {
    
    if (curr != null) {
      printReverseOrder(curr.right);
      System.out.printf("node value = %d\n", curr.value);
      
      printReverseOrder(curr.left);
    }
  }

  // print, reverse-order
  public void printReverseOrder() {
    printReverseOrder(this);
  }

  static void print2DUtil(Node root, int space)
{
    // Base case
    if (root == null)
        return;
 
    // Increase distance between levels
    space += COUNT;
 
    // Process right child first
    print2DUtil(root.right, space);
 
    // Print current node after space
    // count
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
        System.out.print(" ");
    System.out.print(root.value + "\n");
 
    // Process left child
    print2DUtil(root.left, space);
}
 
// Wrapper over print2DUtil()
static void print2D(Node root)
{
    // Pass initial space count as 0
    print2DUtil(root, 0);
}

}
