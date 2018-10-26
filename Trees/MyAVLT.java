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

    MyAVLNode<T> root;

    public MyAVLT() {
        this.root = null;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private void clear() {
        this.root = null;
    }

    //contains routine
    public boolean contains(T element) {
        return contains(element, root);

    }

    private boolean contains(T element, MyAVLNode n) {
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

    private MyAVLNode<T> findMax(MyAVLNode<T> n) {
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

    private MyAVLNode<T> findMin(MyAVLNode<T> n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return findMin(n.getLeft());
        }
    }

    //Insert routine
    public void insert(T element) {
        if (root == null) {
            root = new MyAVLNode<>(element, null, null);
        } else {
            insert(element, root);
        }
    }

    private MyAVLNode<T> insert(T element, MyAVLNode<T> n) {
        if (n == null) {
            return new MyAVLNode<>(element, null, null);
        }

        int compareResult = element.compareTo(n.getElement());

        if (compareResult < 0) {
            n.setLeft(insert(element, n.getLeft()));
        } else if (compareResult > 0) {
            n.setRight(insert(element, n.getRight()));
        } else {
            ; //Duplicat; do nothing
        }
        return balance(n);
    }

    //AVL properties:
    private MyAVLNode<T> singleRightRotation(MyAVLNode<T> k2) {
        MyAVLNode<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }

    private MyAVLNode<T> doubleRightRotation(MyAVLNode<T> k3) {
        k3.setLeft(singleLeftRotation(k3.getLeft()));
        return singleRightRotation(k3);

    }

    private MyAVLNode<T> singleLeftRotation(MyAVLNode<T> k2) {
        MyAVLNode<T> k1 = k2.getRight();
        k2.setRight(k1.getLeft());
        k1.setLeft(k2);
        k2.setHeight(Math.max(height(k2.getRight()), height(k2.getLeft())) + 1);
        k1.setHeight(Math.max(height(k1.getRight()), k2.getHeight()) + 1);
        return k1;
    }

    private MyAVLNode<T> doubleLeftRotation(MyAVLNode<T> k3) {
        k3.setRight(singleRightRotation(k3.getRight()));
        return singleLeftRotation(k3);
    }

    private MyAVLNode<T> balance(MyAVLNode<T> node) {
        if (node == null) {
            return node;
        }

        if (height(node.getLeft()) - height(node.getRight()) > 1) {
            if (height(node.getLeft().getLeft()) >= height(node.getLeft().getRight())) {
                node = singleRightRotation(node);
            } else {
                node = doubleRightRotation(node);
            }

        } else {
            if (height(node.getRight()) - height(node.getLeft()) > 1) {
                if (height(node.getRight().getRight()) >= height(node.getRight().getLeft())) {
                    node = singleLeftRotation(node);
                } else {
                    node = doubleLeftRotation(node);
                }

            }

        }
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        return node;

    }

    //Remove routine
    public void remove(T element) {
        if ((element == root.getElement()) && ((root.getLeft() == null) || (root.getRight() == null))) {
            root = remove(element, root);
        } else {
            remove(element, root);
        }
    }

    private MyAVLNode<T> remove(T element, MyAVLNode n) {
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

        return balance(n);

    }

    //Find height routine
    private int height(MyAVLNode<T> node) {
        if (node == node) {
            return -1;
        } else {
            return node.getHeight();
        }
    }

//    public int height() {
//        if (isEmpty()) {
//            System.out.println("Tree is empty!");
//            return -1;
//        } else {
//            return height(root);
//        }
//
//    }
//
//    private int height(MyAVLNode<T> node) {                
//        if (node.getLeft() == null && node.getRight() == null) {
//            return 0;
//        } else {
//            int treeHeight = 1;
//            int leftHeight = 0, rightHeight = 0;
//
//            if (node.getLeft() != null) {
//                leftHeight = height(node.getLeft()) + treeHeight;
//            }
//            if (node.getRight() != null) {
//                rightHeight = height(node.getRight()) + treeHeight;
//            }
//
//            return getHigher(leftHeight, rightHeight);
//        }
//    }
//
//    private int getHigher(int a, int b) {
//        if (a < b) {
//            return b;
//        } else if (a == b) {
//            return a;
//        } else {
//            return a;
//        }
//    }
    //Print Routine
    public void print() {
        System.out.println("Tree Height: " + root.getHeight());
        print(root, "");
    }

    private void print(MyAVLNode n, String j) {
        if (n != null) {
            System.out.println(j + n.getElement());
            print(n.getLeft(), (j + " "));
            print(n.getRight(), (j + " "));
        } else {
            System.out.println(j + "Null");
        }
    }

}
