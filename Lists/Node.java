/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublelinkelistwithsentinel;

/**
 *
 * @author Jhers
 */
public class Node<T> {
   
    T element;
    Node<T> next;
    Node<T> previous;

    //Constructor de Nodo
    public Node(T element, Node<T> nextElement, Node<T> previousElement) {
        this.element = element;
        this.next = nextElement;
        this.previous = previousElement;
    }
    //Retorna el elemento del Nodo
    public T getElement() {
        return element;
    }
    //Modificar el elemento del Nodo
    public void setElement(T element) {
        this.element = element;
    }
    //Retorna el Nodo
    public Node<T> getNext() {
        return next;
    }
    //Retorna el Nodo anterior
    public Node<T> getPrevious(){
        return previous;
    }
    //Modifica el siguiente Nodo
    public void setNext(Node<T> next) {
        this.next = next;
    } 
    //Modifica el anterior nodo
    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }
    
}
