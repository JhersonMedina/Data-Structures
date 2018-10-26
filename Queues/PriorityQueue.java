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
public interface PriorityQueue<T> {
    
    boolean enqueue(PriorityElement<T> element);

    T dequeue();

    T getFront();

    T getBack();

    void print();

    int size();

    boolean isEmpty();
    
    void clear();
    
}
