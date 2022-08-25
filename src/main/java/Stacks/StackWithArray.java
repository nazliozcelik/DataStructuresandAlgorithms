package Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackWithArray {

    List<Integer> arr = new ArrayList<>();

    public StackWithArray() {
    }

    public int peak(){
        if (arr.size() == 0){
            throw new EmptyStackException();
        }
        System.out.println(arr.get(arr.size()-1));
        return arr.get(arr.size()-1);
    }

    public int pop(){
        if (arr.size() == 0){
            throw new EmptyStackException();
        }
        return arr.remove(arr.size()-1);
    }

    public void push(int val){
        arr.add(val);
    }

    public void printStack(){
        for (int value : arr){
            System.out.print(value);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackWithArray myStack = new StackWithArray();
        myStack.push(2);
        myStack.push(3);
        myStack.push(5);
        myStack.printStack();
        myStack.pop();
        myStack.printStack();
        myStack.peak();
    }
}
