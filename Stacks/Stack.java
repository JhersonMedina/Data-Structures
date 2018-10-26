/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.stack;

/**
 *
 * @author jccas
 * @param <T>
 */
public interface Stack<T> {
    
    public void push(T element);
    
    public T pop();
    
    public T top();
    
    public void clear();
    
    public int size();
    
    public boolean isEmpty();
    
    public void print();
    
}
