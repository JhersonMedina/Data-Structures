/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Estudiante
 * @param <T>
 */
public class MyBinaryNode <T>{
    private T element;
    private MyBinaryNode <T> left;
    private MyBinaryNode <T> right;

    public MyBinaryNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public MyBinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(MyBinaryNode<T> left) {
        this.left = left;
    }

    public MyBinaryNode<T> getRight() {
        return right;
    }

    public void setRight(MyBinaryNode<T> right) {
        this.right = right;
    }
    
    
}