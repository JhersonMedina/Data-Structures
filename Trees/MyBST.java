/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Jhers
 * @param <T>
 */
public class MyBST<T extends Comparable> {

    MyBinaryNode<T> root;

    //Constructor
    public MyBST() {
        this.root = null;
    }

    //Checking if empty or not
    private boolean isEmpty() {
        return root == null;
    }

    //Delete the tree
    private void clear() {
        this.root = null;
    }

    //contains routine
    public boolean contains(T element) {
        return contains(element, root);

    }
    private boolean contains(T element, MyBinaryNode n) {
        if (n == null) {
            return false;
        }
        int compareResult = element.compareTo(n.getElement());
        if (compareResult < 0) {
            return contains(element, n.getLeft());
        } else if (compareResult > 0) {
            return contains(element, n.getRight());
        } else {
            return true;
        }

    }

    //FindMax routine
    public T findMax() {
        if (root == null) {
            return null;
        } else {
            return findMax(root).getElement();
        }
    }
    private MyBinaryNode<T> findMax(MyBinaryNode<T> n) {
        if (n.getRight() == null) {
            return n;
        } else {

            return findMax(n.getRight());
        }
    }

    //FindMin routine
    public T findMin() {
        if (root == null) {
            return null;
        } else {
            return findMin(root).getElement();
        }
    }
    private MyBinaryNode<T> findMin(MyBinaryNode<T> n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return findMin(n.getLeft());
        }
    }

    //insert routine
    public void insert(T element) {
        if (root == null) {
            root = new MyBinaryNode<>(element, null, null);
        } else {
            insert(element, root);
        }
    }
    private MyBinaryNode<T> insert(T element, MyBinaryNode<T> n) {
        if (n == null) {
            return new MyBinaryNode<>(element, null, null);
        }
        int compareResult = element.compareTo(n.getElement());

        if (compareResult < 0) {
            n.setLeft(insert(element, n.getLeft()));
        } else if (compareResult > 0) {
            n.setRight(insert(element, n.getRight()));
        }

        return n;
    }

     //Remove routine
    public void remove(T element) {
        if ((element == root.getElement()) && ((root.getLeft() == null) || (root.getRight() == null))) {
            root = remove(element, root);
        } else {
            remove(element, root);
        }
    }
    private MyBinaryNode<T> remove(T element, MyBinaryNode n) {
        if (n == null) {
            return null;
        }
        int compareResult = element.compareTo(n.getElement());

        if (compareResult < 0) {
            n.setLeft(remove(element, n.getLeft()));
        } else if (compareResult > 0) {
            n.setRight(remove(element, n.getRight()));
        } else if (n.getLeft() != null && n.getRight() != null) {
            n.setElement(findMin(n.getRight()).getElement());
            n.setRight(remove((T) n.getElement(), n.getRight()));
        } else {
            n = (n.getLeft() != null) ? n.getLeft() : n.getRight();

        }
        return n;

    }

    //Applying height method without a height atribute in each node
    public int height() {
        if (isEmpty()) {
            return -1;
        } else {
            return height(root);
        }

    }
    private int height(MyBinaryNode<T> node) {
        
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        } else {
            int treeHeight = 1;
            int leftHeight = 0, rightHeight = 0;

            if (node.getLeft() != null) {
                leftHeight = height(node.getLeft()) + treeHeight;
            }
            if (node.getRight() != null) {
                rightHeight = height(node.getRight()) + treeHeight;
            }

            return Math.max(leftHeight, rightHeight);
        }
    }

    //Print method
    public void print() {
        print(root, "");
    }
    private void print(MyBinaryNode n, String j) {
        if (n != null) {
            System.out.println(j + n.getElement());
            print(n.getLeft(), (j + " "));
            print(n.getRight(), (j + " "));
        } else {
            System.out.println(j + "Null");
        }
    }
}
