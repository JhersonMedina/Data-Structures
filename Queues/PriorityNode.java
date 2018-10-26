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
public class PriorityNode<T> {
    
    T element;
    PriorityNode<T> nextNode;
    int priority;

    public PriorityNode(T element, PriorityNode<T> nextNode, int priority) {
        this.element = element;
        this.nextNode = nextNode;
        this.priority = priority;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public PriorityNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(PriorityNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
        
}
