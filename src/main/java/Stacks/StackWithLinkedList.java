package Stacks;

import java.util.EmptyStackException;

public class StackWithLinkedList {

    private LinkedNode top;
    private LinkedNode bottom;
    private int length;

    public StackWithLinkedList(){
        top = null;
        bottom = null;
        length = 0;
    }

    public int peak(){
        if(length == 0){
            throw new EmptyStackException();
        }
        System.out.println(top.getValue());
        return top.getValue();
    }

    public int pop(){
        if(length == 0){
            throw new EmptyStackException();
        }
        LinkedNode tempTop = top;
        top = top.getNext();
        length--;
        return tempTop.getValue();
    }

    public void push(int val){
        if (length == 0){
            bottom = top;
        }
        top = new LinkedNode(val, top);
        length++;
    }

    public void printStack(){
        if (top == null){
            return;
        }
        LinkedNode currentNode = top;
        System.out.print(currentNode.getValue());
        currentNode = currentNode.getNext();
        while (currentNode != null){
            System.out.print(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithLinkedList myStack = new StackWithLinkedList();
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.printStack();
        myStack.peak();
        myStack.pop();
        myStack.printStack();
    }
}
