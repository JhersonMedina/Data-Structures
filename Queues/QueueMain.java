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
public class QueueMain {
    
    public static void main(String []args)
    {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        System.out.println("***********QUEUE IMPLEMENTATION");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(-5);
        queue.enqueue(-30);
        System.out.println("Enqueue four elemens into the queue. Size: " + queue.size());
        System.out.println("Front of queue: " + queue.getFront() + ". Back of queue: " + queue.getBack());
        queue.print();
        System.out.println("Dequeue an element. Value: " + queue.dequeue());
        System.out.println("Dequeue an element. Value: " + queue.dequeue());
        System.out.println("Dequeue two elements. Size: " + queue.size());
        System.out.println("Front of queue: " + queue.getFront() + ". Back of queue: " + queue.getBack());
        queue.print();
        queue.enqueue(23);
        queue.enqueue(-10);
        queue.enqueue(50);
        System.out.println("Enqueue three new elements. Size: " + queue.size());
        System.out.println("Front of queue: " + queue.getFront() + ". Back of queue: " + queue.getBack());
        queue.print();
        
        
        System.out.println("");
        System.out.println("********************BASIC PRIORITY QUEUE IMPLEMENTATION");
        MyPriorityArrayQueue<Integer> priorityQueue = new MyPriorityArrayQueue<>(2);
        priorityQueue.enqueue(new PriorityElement<>(10, 10));
        priorityQueue.enqueue(new PriorityElement<>(20, 7));
        priorityQueue.enqueue(new PriorityElement<>(-5, 15));
        priorityQueue.enqueue(new PriorityElement<>(-30, 2));
        System.out.println("Enqueue four elemens into the queue. Size: " + priorityQueue.size());
        System.out.println("Front of queue: " + priorityQueue.getFront() + ". Back of queue: " + priorityQueue.getBack());
        priorityQueue.print();
        System.out.println("Dequeue an element. Value: " + priorityQueue.dequeue());
        System.out.println("Dequeue an element. Value: " + priorityQueue.dequeue());
        System.out.println("Dequeue two elements. Size: " + priorityQueue.size());
        System.out.println("Front of queue: " + priorityQueue.getFront() + ". Back of queue: " + priorityQueue.getBack());
        priorityQueue.print();
        priorityQueue.enqueue(new PriorityElement<>(23, 15));
        priorityQueue.enqueue(new PriorityElement<>(-10, 3));
        priorityQueue.enqueue(new PriorityElement<>(50, 1));
        System.out.println("Enqueue three new elements. Size: " + priorityQueue.size());
        System.out.println("Front of queue: " + priorityQueue.getFront() + ". Back of queue: " + priorityQueue.getBack());
        priorityQueue.print();
        System.out.println("Dequeue an element. Value: " + priorityQueue.dequeue());
        System.out.println("Dequeue an element. Value: " + priorityQueue.dequeue());
        priorityQueue.print();
        
    }
    
}
