package datastructure.list;

import java.util.Iterator;

public class MyArrayList<T extends Comparable> extends AbstractList<T> {
    
    T[] elementData;
    
    public MyArrayList()
    {
        elementData = (T[]) new Comparable[0];
        this.size = 0;
    }
    
    public MyArrayList(int initialCapacity)
    {
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        
        elementData = (T[]) new Comparable[initialCapacity];
        this.size = 0;
    }
    
    private void ensureCapacity(int minCapacity)
    {
        if (elementData.length < minCapacity)
        {
            int newArraySize;
            if (elementData.length == 0)
                newArraySize = 1;
            else
                newArraySize = elementData.length * 2;
            
            T[] newArray = (T[]) new Comparable[newArraySize];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];                
            }
            elementData = newArray;            
        }
    }
    

    @Override
    public T get(int index) {
        if (index >= 0 && index < size)
            return elementData[index];        
        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public boolean add(T element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if(index >= 0 && index <= size)
        {
            ensureCapacity(size + 1);
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i + 1] = elementData[i];                
            }
            elementData[index] = element;
            size++;
        }
        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public void set(int index, T element) {
        if (index >= 0 && index < size)
        {
            elementData[index] = element;
        }
        else
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public T remove(int index) {
        if (index > 0 && index < size)
        {
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i] = elementData[i + 1];                
            }
            elementData[size - 1] = null;
            size--;
        }
        throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }    
   
    public Iterator<T> iterator()
    {
        return new MyArrayListListener();
    }
    
    private class MyArrayListListener implements Iterator<T>
    {
        
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (hasNext())
                return elementData[current++];
            
            return null;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
        
        public void reset()
        {
            current = 0;
        }
        
    }
}
