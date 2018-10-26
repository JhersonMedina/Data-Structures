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

        //Binary seatch tree
        System.out.println("BINARY SEARH TREE: ");
        MyBST<Integer> myTree = new MyBST<>();
        myTree.height();
        myTree.insert(7);
        myTree.insert(5);
        myTree.insert(2);
        myTree.insert(10);
        myTree.insert(8);
        myTree.insert(9);

        System.out.println("Tree itself:");
        myTree.print();

        System.out.println("Smallest element: " + myTree.findMin());
        System.out.println("Biggest element: " + myTree.findMax());

        myTree.remove(2);
        System.out.println("Smallest Element: " + myTree.findMin());

        System.out.println("is 5 conatained? : " + myTree.contains(5));
        System.out.println("is 0 contained: " + myTree.contains(0));

        System.out.println("Tree height: " + myTree.height());

        //AVL Tree
        System.out.println("AVL TREE: ");
        MyAVLT<Integer> myAVLTree = new MyAVLT<>();
        myAVLTree.height();

        myAVLTree.insert(2);
       // myAVLTree.insert(1);
        //myAVLTree.insert(4);
        //myAVLTree.insert(3);
        //myAVLTree.insert(5);
        //myAVLTree.insert(6);
        
        //myAVLTree.print();
        //System.out.println("AVL Tree: " + myAVLTree.height());

    }
}
