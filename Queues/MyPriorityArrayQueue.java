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
public class MyPriorityArrayQueue<T> implements PriorityQueue<T> {
    
    private PriorityElement<T> elementData[];    
    private int front;
    private int back;
    private int size;
    private int priorityDequeues;
    private int contPriorityDequeues;

    public MyPriorityArrayQueue(int priorityDequeues)
    {
        elementData = (PriorityElement<T>[])new PriorityElement[2];
        front = 0;
        back = -1;
        size = 0;
        contPriorityDequeues = 0;
        this.priorityDequeues = priorityDequeues;        
    }

    @Override
    public boolean enqueue(PriorityElement<T> element) {
     
        back = (back + 1) % elementData.length;
        
        if(back == front)
        {
            PriorityElement<T>[] newElementData = (PriorityElement<T>[])new PriorityElement[elementData.length * 2];
            int newPos = 0;
            if (front < back || (front == back && size == 1))
            {
                for (int i = front; i <= back; i++) {
                    newElementData[newPos++] = elementData[i];
                }                
            }
            else
            {
                for (int i = front; i < elementData.length; i++) {
                    newElementData[newPos++] = elementData[i];                    
                }
                for (int i = 0; i <= back; i++) {
                    newElementData[newPos++] = elementData[i]; 
                }
            }
            front = 0;
            back = size;
            elementData = newElementData;
        }       
        
        elementData[back] = element;
        size++;       
        return true;
    }

    @Override
    public T dequeue() {        
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        
        if (contPriorityDequeues < priorityDequeues)
        {
            contPriorityDequeues++;            
            int posMaxPriority = front;
            int maxPriority = elementData[front].getPriority();
            if (front < back || (front == back && size == 1))
            {
                for (int i = front + 1; i <= back; i++) {
                    if(elementData[i].getPriority() > maxPriority)
                    {
                        maxPriority = elementData[i].getPriority();
                        posMaxPriority = i;
                    }
                }
                if (posMaxPriority > front && posMaxPriority <= back)
                {
                    T elementMaxPriority = elementData[posMaxPriority].getElement();
                    for (int i = posMaxPriority; i < back; i++) {
                        elementData[i] = elementData[i + 1];                        
                    }
                    back--;
                    size--;
                    return elementMaxPriority;
                }                
            }
            else
            {
                for (int i = front; i < elementData.length; i++) {
                    if(elementData[i].getPriority() > maxPriority)
                    {
                        maxPriority = elementData[i].getPriority();
                        posMaxPriority = i;
                    }
                }
                for (int i = 0; i <= back; i++) {
                    if(elementData[i].getPriority() > maxPriority)
                    {
                        maxPriority = elementData[i].getPriority();
                        posMaxPriority = i;
                    }
                }
                T elementMaxPriority = elementData[posMaxPriority].getElement();
                if(posMaxPriority > front)
                {
                    size--;
                    for (int i = posMaxPriority; i >= front; i--) {
                        elementData[i] = elementData[i - 1];                        
                    }
                    front++;
                    return elementMaxPriority;
                }
                else if(posMaxPriority <= back)
                {
                    size--;
                    for (int i = posMaxPriority; i < back; i++) {
                        elementData[i] = elementData[i + 1];                        
                    }
                    back--;
                    return elementMaxPriority;
                }                
            }           
        }
        else
            contPriorityDequeues = 0;
        T elementMaxPriority = elementData[front].getElement();
        size--;
        front = (front + 1) % elementData.length;
        return elementMaxPriority;
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return elementData[front].getElement();
    }

    @Override
    public T getBack() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return elementData[back].getElement();
    }

    @Override
    public void print() {
        
        if (front < back || (front == back && size == 1))
            {
                for (int i = front; i <= back; i++) {
                    System.out.println(elementData[i].toString());
                }
            }
            else
            {
                for (int i = front; i < elementData.length; i++) {
                    System.out.println(elementData[i].toString());               
                }
                for (int i = 0; i <= back; i++) {
                    System.out.println(elementData[i].toString());
                }
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
        front = 0;
        back = -1;
        size = 0;
        priorityDequeues = 0;
    }    
}
