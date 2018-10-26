/*
 * Author: Jherson Adrian Medina Correa
 */
package parcial1;

/**
 *
 * @author jccas
 * @param <T>
 */
public class MyDoubleLinkedList<T extends Comparable> {

    private Node<T> root;
    private Node<T> tail;
    int size;

    public MyDoubleLinkedList() {
        initialize();
    }

    private void initialize() {
        root = new Node<>(null, null, null);
        tail = new Node<>(null, null, root);
        root.setNext(tail);
        size = 0;
    }

    private Node<T> getNode(int index, boolean toAdd) {
        boolean upperBound = (toAdd && index <= size) || (!toAdd && index < size);
        boolean lowerBound = index >= 0;

        if (lowerBound && upperBound) {
            Node<T> node;

            if (index < size / 2) {
                node = root.getNext();
                for (int i = 0; i < index; i++) {
                    node = node.getNext();
                }
            } else {
                node = tail;
                for (int i = size; i > index; i--) {
                    node = node.getBefore();
                }
            }
            return node;
        }

        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public T get(int index) {
        return getNode(index, false).getElement();
    }

    public boolean add(T element) {
        add(size, element);
        return true;
    }

    public void add(int index, T element) {
        Node<T> newNextNode = getNode(index, true);
        Node<T> newBeforeNode = newNextNode.getBefore();
        Node<T> newNode = new Node<>(element, newNextNode, newBeforeNode);
        newBeforeNode.setNext(newNode);
        newNextNode.setBefore(newNode);
        size++;
    }

    public void set(int index, T element) {
        Node<T> actualNode = getNode(index, false);
        actualNode.setElement(element);
    }

    public T remove(int index) {
        Node<T> removeNode = getNode(index, false);
        removeNode.getBefore().setNext(removeNode.getNext());
        removeNode.getNext().setBefore(removeNode.getBefore());
        size--;
        return removeNode.getElement();
    }

    public void clear() {
        initialize();
    }

    public int size() {
        return size;
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (get(i).compareTo(get(j)) == 1) {
                    T newElement = get(i);
                    getNode(i, false).setElement(get(j));
                    getNode(j, false).setElement(newElement);
                }
            }
        }
    }

    public String toString() {
        String result = "";
        Node<T> node = root.getNext();
        while (node != tail) {
            result += node.getElement().toString();
            node = node.getNext();
        }
        return result;
    }

}
