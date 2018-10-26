/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.list;

/**
 *
 * @author jccas
 * @param <T>
 */
public interface List<T> {
    
    //Return size of list
    int size();
    
    //Return element in the index position
    T get(int index);
    
    //Add a new element in the list
    boolean add(T element);
    
    //Add a new element in the index position. Other elements must be moved
    void add(int index, T element);
    
    //Replace an element in the index position
    void set(int index, T element);
    
    //Return true if the list is empty otherwise false.
    boolean isEmpty();
    
    //Delete an element in the index position. Other elements must be moved
    T remove(int index);
    
    //Clear the list
    void clear();
    
    //Print the list in console
    void print();
    
    //Sort the list
    void sort();
    
    
    
}
