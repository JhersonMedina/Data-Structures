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
public class MyLinkedPriorityQueue<T> implements PriorityQueue<T> {
    
    PriorityNode<T> front;
    PriorityNode<T> back;
    int size;
    
    public MyLinkedPriorityQueue()
    {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean enqueue(PriorityElement<T> element) {
        PriorityNode<T> newNode = new PriorityNode<>(element.getElement(), null, element.getPriority());
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
        
        int maxPriority = front.getPriority();
        PriorityNode<T> maxPriorityNode = front;
        PriorityNode<T> beforeMaxPriorityNode = null;
        PriorityNode<T> iterableNode = front;
        while(iterableNode.getNextNode() != null)
        {
            if(iterableNode.getNextNode().getPriority() > maxPriority)
            {
                maxPriority = iterableNode.getNextNode().getPriority();
                maxPriorityNode = iterableNode.getNextNode();
                beforeMaxPriorityNode = iterableNode;
            }
            iterableNode = iterableNode.getNextNode();
        }
        T dequeuedElement = maxPriorityNode.getElement();
        if (maxPriorityNode == front)
        {            
            front = front.getNextNode();            
        }
        else
        {
            beforeMaxPriorityNode.setNextNode(maxPriorityNode.getNextNode());
        }
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
        PriorityNode<T> n = front;
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
