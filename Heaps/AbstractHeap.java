/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

/**
 *
 * @author Jhers
 * @param <T>
 */
public abstract class AbstractHeap<T extends Comparable> implements Heap<T> {
    
    @Override
    public abstract int  size();
    
    @Override
    public abstract boolean isEmpty();
    
    @Override
    public abstract void clear();
    
    @Override
    public abstract void print();
    
    @Override
    public abstract void insert(T element);
    
    @Override
    public abstract  T findMin();
    
    @Override
    public abstract T removeMin();
}
