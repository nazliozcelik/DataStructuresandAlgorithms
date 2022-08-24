package LinkedLists.Doubly;

public class LinkedList {

    private LinkedNode head;
    private LinkedNode tail;
    private int length;

    public LinkedList(int value){
        head = new LinkedNode(value);
        tail = head;
        length = 1;
    }

    public void prepend(int value){
        LinkedNode newNode = new LinkedNode(value, null, head);
        head.setPrev(newNode);
        head = newNode;
        length++;
    }

    public void append(int value){
        LinkedNode newNode = new LinkedNode(value, tail, null);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void insert(int index, int value){
        if (index == 0){
            prepend(value);
        }

        if (index == length - 1){
            append(value);
        }

        if (index >= length){
            System.out.println("You entered an invalid index, please try again. Now, current list is below");
            printList();
            return;
        }

        LinkedNode leader = traverseToIndex(index - 1);
        LinkedNode follower = leader.getNext();

        LinkedNode newNode = new LinkedNode(value, leader, follower);
        leader.setNext(newNode);
        follower.setPrev(newNode);
        length++;
    }

    public void remove(int index){
        if (index == 0){
            head = head.getNext();
        }

        if (index == length){
            System.out.println("You entered an invalid index");
            return;
        }

        if (index > length){
            System.out.println("You entered an invalid index, please try again. Now, current list is below");
            printList();
            return;
        }

        LinkedNode leader = traverseToIndex(index - 1);
        LinkedNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrev(leader);
        length--;
    }

    public void printList(){
        if (head == null){
            return;
        }

        LinkedNode currentNode = head;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null){
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public LinkedNode traverseToIndex(int index) {
        LinkedNode currentNode = head;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList(1);
        myList.append(2);
        myList.append(5);
        myList.append(4);
        myList.prepend(3);
        myList.printList();
        myList.insert(2, 7);
        myList.printList();
        myList.remove(6);
        myList.printList();
    }
}
