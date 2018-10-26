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
public class QueueNode<T> {
    
    T element;
    QueueNode<T> nextNode;

    public QueueNode(T element, QueueNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public QueueNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(QueueNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    
    
}
