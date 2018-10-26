/*
 * Author: Jherson Adrian Medina Correa
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class MyLinkedStack<T> {

    StackNode<T> top;
    int size;
    
    public MyLinkedStack()
    {
        top = null;
        size = 0;
    }    
    
    public void push(T element) {
        StackNode<T> newNode = new StackNode<>(element, top);
        top = newNode;
        size++;
    }

    
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        T poppedElement = top.getElement();
        top = top.getNextNode();
        size--;
        return poppedElement;
    }

    
    public T top() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return top.getElement();
    }
    
    public void clear() {
        top = null;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void print() {
        StackNode<T> n = top;
        while(n != null)        
        {
            System.out.println(n.getElement());
            n = n.getNextNode();
        }
    }
    
}
