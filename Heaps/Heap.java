/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

/**
 *
 * @author Jhers
 */
public interface Heap <T> {
    //Return the size of the heap: the number of elements
    int size();
    
    //Check wether the heap is empty or not
    boolean isEmpty();
    
    //Errase the heap
    void clear();
    
    //Print the heap
    void print();
    
    //Insert element in to the the heap
    public void insert(T element);
    
    //Finds the smallest element
    public T findMin();
    
    //Remove the smallest element
    public T removeMin();
}
