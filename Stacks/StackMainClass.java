/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.stack;

/**
 *
 * @author jccas
 */
public class StackMainClass {
    
    public static void main(String[] args) {
        
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        
        stack.push(10);
        stack.push(15);
        stack.push(-10);
        stack.push(20);
        System.out.println("Push four elements. Size: " + stack.size());
        stack.print();        
        System.out.println("Stack top: " + stack.top() + ". Size: " + stack.size());        
        stack.pop();
        System.out.println("Pop an element. Size: " + stack.size());
        stack.print();
        System.out.println("Before Clear Stack, isEmpty? " + stack.isEmpty() + " Size: " + stack.size());
        stack.clear();
        System.out.println("After Clear stack, isEmpty? " + stack.isEmpty() + " Size: " + stack.size());
        stack.print();
        
        
    }
    
}
