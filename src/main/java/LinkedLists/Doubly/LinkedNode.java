package LinkedLists.Doubly;

public class LinkedNode {

    private int value;
    private LinkedNode prev;
    private LinkedNode next;

    public LinkedNode(int value){
        this.value = value;
        this.next = null;
    }

    public LinkedNode(int value, LinkedNode prev, LinkedNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode prev) {
        this.prev = prev;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
