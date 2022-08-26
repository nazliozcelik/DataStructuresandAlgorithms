package Queues;

public class LinkedNode {

    private int val;
    private LinkedNode next;

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
