/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Jhers
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Binary seatch tree implementation
        System.out.println("******************BINARY SEARH TREE***************");
        MyBST<Integer> myTree = new MyBST<>();
        myTree.insert(3);
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(4);
        myTree.insert(5);
        myTree.insert(6);
        myTree.insert(7);
        myTree.insert(16);
        myTree.insert(15);
        myTree.insert(14);
        myTree.insert(13);
        myTree.insert(12);
        myTree.insert(11);
        myTree.insert(10);
        myTree.insert(8);
        myTree.insert(9);

        System.out.println("Tree height: " + myTree.height());
        System.out.println("Tree itself:");
        myTree.print();

        System.out.println("Smallest element: " + myTree.findMin());
        System.out.println("Biggest element: " + myTree.findMax());

        myTree.remove(2);
        System.out.println("Smallest Element: " + myTree.findMin());

        System.out.println("is 5 conatained? : " + myTree.contains(5));
        System.out.println("is 0 contained: " + myTree.contains(0));

        System.out.println("Tree after removing element 2:");
        System.out.println("Tree height: " + myTree.height());
        myTree.print();

        //AVL Tree implementation
        System.out.println("***************AVL TREE**************");
        MyAVLT<Integer> myAVLTree = new MyAVLT<>();

        myAVLTree.insert(3);
        myAVLTree.insert(2);
        myAVLTree.insert(1);
        myAVLTree.insert(4);
        myAVLTree.insert(5);
        myAVLTree.insert(6);
        myAVLTree.insert(7);
        myAVLTree.insert(16);
        myAVLTree.insert(15);
        myAVLTree.insert(14);
        myAVLTree.insert(13);
        myAVLTree.insert(12);
        myAVLTree.insert(11);
        myAVLTree.insert(10);
        myAVLTree.insert(8);
        myAVLTree.insert(9);

        System.out.println("Tree itself:");
        myAVLTree.print();

        System.out.println("Smallest element: " + myAVLTree.findMin());
        System.out.println("Biggest element: " + myAVLTree.findMax());

        myAVLTree.remove(2);
        System.out.println("Smallest Element: " + myAVLTree.findMin());

        System.out.println("is 5 conatained? : " + myAVLTree.contains(5));
        System.out.println("is 0 contained: " + myAVLTree.contains(0));

        System.out.println("Tree after removing element 2:");
        myAVLTree.print();
    }
}
