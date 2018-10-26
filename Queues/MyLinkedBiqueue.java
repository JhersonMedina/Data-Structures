/*
 * Author: Jherson Adrian Medina Correa
 */
package parcial1;

/**
 *
 * @author juan.castro
 */
public class MyLinkedBiqueue<T> {
    
    QueueNode<T> front;
    QueueNode<T> back;
    int size;
    
    public MyLinkedBiqueue()
    {
        front = null;
        back = null;
        size = 0;
    }

    
    public void enqueue(T element, boolean inBack) {   
        if(isEmpty()){
            QueueNode newNode = new QueueNode(element, null);
            front = newNode;
            back = front;
            size++;
        }else{
            if(inBack){
                QueueNode newNode = new QueueNode(element, null);
                back.setNextNode(newNode);
                back = newNode;
                size++;
            }
            else{
                QueueNode newNode = new QueueNode(element, front);
                front = newNode;
                size++;
            }
        
        
        }   
        
    }

    
    public T dequeue(boolean fromFront) {
        if(size() == 0){
            return null;
        }
        else{
            if(fromFront){
                T dequeueNode = front.getElement();
                front = front.nextNode;
                size--;
                return dequeueNode;
            }
            else{
                T aux = back.getElement();
                QueueNode<T> auxNode = front;
                while(auxNode.getNextNode().getNextNode() != null){
                    auxNode = auxNode.getNextNode();
                }
                back = auxNode;
                return aux;
            }
        }
    }

    
    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return front.getElement();
    }

    
    public T getBack() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return back.getElement();
    }

    
    public void print() {
        QueueNode<T> n = front;
        while(n != null)        
        {
            System.out.println(n.getElement().toString());
            n = n.getNextNode();
        }
    }

    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
    
    public String toString()
    {
        QueueNode<T> n = front;
        String result = "";
        while(n != null)        
        {
            result += n.getElement().toString();
            n = n.getNextNode();
        }
        return result;
    }
    
}
