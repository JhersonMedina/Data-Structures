/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.queue;

/**
 *
 * @author juan.castro
 * @param <T>
 */
public class PriorityElement<T> {
    
    private T element;
    private int priority;

    public PriorityElement(T element, int priority) {
        this.element = element;
        this.priority = priority;
    }
    
    

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return element.toString() + " , " + priority;
    }
    
    
    
}
