package datastructure.list;

import java.util.Iterator;

public class IntegerArrayList {

    private int size;
    private Integer[] elementData;

    public IntegerArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Integer[initialCapacity];
        } else
        {
            this.elementData = new Integer[0];
        }
        this.size = 0;
    }

    public IntegerArrayList() {
        this.elementData = new Integer[0];
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
            
            Integer[] newArray = new Integer[newArraySize];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];                
            }
            elementData = newArray;            
        }
    }

    public boolean add(Integer val)
    {
        ensureCapacity(size + 1);
        elementData[size++] = val;
        return true;
    }
    
    public void add(int index, Integer val)
    {
        if(index >= 0 && index <= size)
        {
            ensureCapacity(size + 1);
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i + 1] = elementData[i];                
            }
            elementData[index] = val;
            size++;
        }
    }
    
    public Integer get(int index)
    {
        if (index > 0 && index < size)
            return elementData[index];
        else
            return null;
    }
    
    public void set(int index, Integer value)
    {
        if (index > 0 && index < size)
        {
            elementData[index] = value;
        }
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void remove(int index)
    {
        if (index > 0 && index < size)
        {
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i] = elementData[i + 1];                
            }
            elementData[size - 1] = null;
            size--;
        }
    }
    
    public void print()
    {
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");            
        }
        System.out.println("");              
    }
    
    public void clear()
    {
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }
    
    public void sort()
    {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if(elementData[i] > elementData[j])
                {
                    Integer aux = elementData[i];
                    elementData[i] = elementData[j];
                    elementData[j] = aux;
                }                
            }            
        }
    }
    
    public Iterator<Integer> iterator()
    {
        return new NumArrayListListener();
    }
    
    private class NumArrayListListener implements Iterator<Integer>
    {
        
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Integer next() {
            if (hasNext())
                return elementData[current++];
            
            return null;
        }

        @Override
        public void remove() {
            IntegerArrayList.this.remove(--current);
        }
        
        public void reset()
        {
            current = 0;
        }
        
    }
    




}
