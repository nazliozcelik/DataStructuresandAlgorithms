package LinkedLists.Singly;

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
        head = new LinkedNode(value, head);
        length++;
    }

    public void append(int value){
        LinkedNode newNode = new LinkedNode(value);
        tail.setNext(newNode);
        tail = newNode;
        length++;
    }

    public void insert(int index, int value){
        if (index == 0){
            prepend(value);
        }
        if (index == length -1){
            append(value);
        }

        LinkedNode leader = traverseToIndex(index - 1);
        LinkedNode nextNode = leader.getNext();

        LinkedNode newNode = new LinkedNode(value, nextNode);
        leader.setNext(newNode);
        length++;
    }

    public void remove(int index){
        if (index == 0){
            head = head.getNext();
        }

        if (index > length){
            System.out.println("You entered an invalid index, please try again. Now, current list is below");
            printList();
            return;
        }

        LinkedNode leader = traverseToIndex(index - 1);
        LinkedNode nodeToRemove = leader.getNext();
        leader.setNext(nodeToRemove.getNext());
        length --;
    }

    public void reverse(){
        LinkedNode first = head;
        tail = head;
        LinkedNode second = first.getNext();
        for (int i = 0; i < length -1; i++){
            LinkedNode temp = second.getNext();
            second.setNext(first);
            first = second;
            second = temp;
        }
        head.setNext(null);
        head = first;
    }

    private LinkedNode traverseToIndex(int index) {
        LinkedNode currentNode = head;
        for (int i = 0; i < index; i++){
            currentNode = currentNode.getNext();
        }
        return currentNode;
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

    public static void main(String[] args) {
        LinkedList myList = new LinkedList(2);
        myList.append(1);
        myList.append(3);
        myList.append(5);
        myList.append(4);
        myList.prepend(8);
        myList.printList();
        myList.remove(2);
        myList.printList();
        myList.reverse();
        myList.printList();
    }
}
