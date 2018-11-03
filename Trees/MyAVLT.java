/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Jhers
 * @param T
 */
public class MyAVLT<T extends Comparable> {

    MyBinaryNode<T> root;

    //Constructor
    public MyAVLT() {
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

    //Insert routine
    public void insert(T element) {
        root = insert(element, root);
    }
    private MyBinaryNode<T> insert(T element, MyBinaryNode<T> node) {
        if (node == null) {
            return new MyBinaryNode<>(element, null, null);
        }

        int compareResult = element.compareTo(node.getElement());

        if (compareResult < 0) {
            node.setLeft(insert(element, node.getLeft()));
        } else if (compareResult > 0) {
            node.setRight(insert(element, node.getRight()));
        }else{
            ;
        }

        return balance(node);
    }

    //AVL properties:
    
    //Rotation to fix case 1: rotateWithLeftChild
    private MyBinaryNode<T> singleRightRotation(MyBinaryNode<T> k2) {
        MyBinaryNode<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }
   
    //Rotation to fix case 2: doubleWithLeftChild
    private MyBinaryNode<T> leftRightRotation(MyBinaryNode<T> k3) {
        k3.setLeft(singleLeftRotation(k3.getLeft()));
        return singleRightRotation(k3);

    }

    //Rotation to fix case 4: rotateWithRightChild
    private MyBinaryNode<T> singleLeftRotation(MyBinaryNode<T> k1) {
        MyBinaryNode<T> k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }

    //Rotation ro fix case 3: doubleWithRightChild
    private MyBinaryNode<T> rightLeftRotation(MyBinaryNode<T> k1) {
        k1.setRight(singleRightRotation(k1.getRight()));
        return singleLeftRotation(k1);
    }

    //Asuming node is either balance or within one of being balance
    private MyBinaryNode<T> balance(MyBinaryNode<T> node) {
        if (node == null) {
            return node;
        }
        if (height(node.getLeft()) - height(node.getRight()) > 1) {
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = singleRightRotation(node);
            } else {
                node = leftRightRotation(node);
            }
        } else {
            if (height(node.getRight()) - height(node.getLeft()) > 1) {
                if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                    node = singleLeftRotation(node);
                } else {
                    node = rightLeftRotation(node);
                }
            }
        }
        return node;
    }

    //Remove routine
    public void remove(T element) {
        root = remove(element, root);
    }
    private MyBinaryNode<T> remove(T element, MyBinaryNode<T> node) {
        if (node == null) {
            return node;
        }

        int compareResult = element.compareTo(node.getElement());

        if (compareResult < 0) {
            node.setLeft(remove(element, node.getLeft()));
        } else if (compareResult > 0) {
            node.setRight(remove(element, node.getRight()));
        } else if (node.getLeft() != null && node.getRight() != null) {
            node.setElement(findMin(node.getRight()).getElement());
            node.setRight(remove(node.getElement(), node.getRight()));
        } else {
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }

        return balance(node);

    }

    //Applying height method without a height atribute in each node
    private int height(MyBinaryNode<T> node) {
        if (node == null) {
            return -1;
        } else {
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
    }

    //Print method
    public void print() {
        System.out.println(height(root));
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
