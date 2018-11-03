/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Jhers
 * @Param <T>
 */

//This class is actually never used, its existance is for "just in case"
public class MyAVLNode<T> {
    private T element;
    private MyAVLNode<T> left;
    private MyAVLNode<T> right;
    private int height;

    public MyAVLNode(T element, MyAVLNode<T> left, MyAVLNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        height = 0;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyAVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyAVLNode<T> left) {
        this.left = left;
    }

    public MyAVLNode<T> getRight() {
        return right;
    }

    public void setRight(MyAVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
}
