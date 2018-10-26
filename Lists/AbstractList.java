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
public abstract class AbstractList<T extends Comparable> implements List<T> {

    protected int size;
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public abstract T get(int index); 

    @Override
    public abstract boolean add(T element);        

    @Override
    public abstract void add(int index, T element);

    @Override
    public abstract void set(int index, T element);

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public abstract T remove(int index);

    @Override
    public abstract void clear();

    @Override
    public void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i).toString());            
        }
    }

    @Override
    public void sort()
    {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if(get(i).compareTo(get(j)) == 1)
                {
                    T aux = get(i);
                    set(i,get(j));
                    set(j, aux);                    
                }                
            }            
        }
    }
    
}
