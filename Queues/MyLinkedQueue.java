/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.queue;

/**
 *
 * @author juan.castro
 */
public class MyLinkedQueue<T> implements Queue<T> {
    
    QueueNode<T> front;
    QueueNode<T> back;
    int size;
    
    public MyLinkedQueue()
    {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean enqueue(T element) {        
        QueueNode<T> newNode = new QueueNode<>(element, null);
        if (size > 0)        
            back.setNextNode(newNode);        
        else
            front = newNode;
        
        back = newNode;        
        size++;
        return true;        
    }

    @Override
    public T dequeue() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        T dequeuedElement = front.getElement();
        front = front.getNextNode();
        size--;
        return dequeuedElement;                
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return front.getElement();
    }

    @Override
    public T getBack() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return back.getElement();
    }

    @Override
    public void print() {
        QueueNode<T> n = front;
        while(n != null)        
        {
            System.out.println(n.getElement().toString());
            n = n.getNextNode();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
}
