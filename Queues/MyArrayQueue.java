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
public class MyArrayQueue<T> implements Queue<T> {

    private T elementData[];
    private int front;
    private int back;
    private int size;

    public MyArrayQueue()
    {
        elementData = (T[])new Object[2];
        front = 0;
        back = -1;
        size = 0;

    }

    @Override
    public boolean enqueue(T element) {
     
        back = (back + 1) % elementData.length;
        
        if(back == front)
        {
            T[] newElementData = (T[])new Object[elementData.length * 2];
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
        T elementMaxPriority = elementData[front];
        size--;
        front = (front + 1) % elementData.length;
        return elementMaxPriority;
    }

    @Override
    public T getFront() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return elementData[front];
    }

    @Override
    public T getBack() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("The queue is empty");
        return elementData[back];
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
    }
}

