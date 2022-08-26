package Queues;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList {

    private LinkedNode first;
    private LinkedNode last;
    private int length;

    public QueueUsingLinkedList(){
        first = null;
        last = null;
        length = 0;
    }

    public int peek(){
        if (first == null){
            throw new NoSuchElementException();
        }
        System.out.println(first.getVal());
        return first.getVal();
    }

    public void enqueue(int val){
        LinkedNode newNode = new LinkedNode(val);

        if (length == 0){
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        length++;
    }

    public void dequeue(){
        if (first == null){
            throw new NoSuchElementException();
        }

        first = first.getNext();
        length--;
        if (length == 0){
            last = null;
        }
    }

    public void printQueue(){
        if (first == null){
            return;
        }

        LinkedNode currentNode = first;
        System.out.print(currentNode.getVal());
        currentNode = currentNode.getNext();

        while (currentNode != null){
            System.out.print(currentNode.getVal());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.peek();
    }
}
