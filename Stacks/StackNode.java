/*
 * Author: Jherson Adrian Medina Correa
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class StackNode<T> {
    
    T element;
    StackNode<T> nextNode;

    public StackNode(T element, StackNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public StackNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode<T> nextNode) {
        this.nextNode = nextNode;
    }
    
    
    
}
