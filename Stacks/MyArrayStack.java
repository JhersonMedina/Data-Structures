/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.stack;

/**
 *
 * @author jccas
 */
public class MyArrayStack<T> implements Stack<T> {

    private T elementData[];
    
    private int topOfStack;
    
    public MyArrayStack()
    {
        elementData = (T[]) new Object[1];
        topOfStack = -1;
    }
    
    private void ensureCapacity(int minCapacity)
    {
        if (elementData.length < minCapacity)
        {
            int newArraySize;            
            newArraySize = elementData.length * 2;            
            T[] newArray = (T[]) new Object[newArraySize];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];                
            }
            elementData = newArray;            
        }
    }
    
    
    @Override
    public void push(T element) {
        ensureCapacity(size() + 1);
        elementData[++topOfStack] = element;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return elementData[topOfStack--];
    }

    @Override
    public T top() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return elementData[topOfStack];
    }

    @Override
    public void clear() {
        topOfStack = -1;
    }

    @Override
    public int size() {
        return topOfStack + 1;
    }

    @Override
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    @Override
    public void print() {
        for (int i = topOfStack; i >= 0 ; i--) {
            System.out.println(elementData[i]);      
        }
    }
    
    
}
