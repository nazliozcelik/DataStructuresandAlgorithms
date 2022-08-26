package Queues;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> helperStack = new Stack<>();

    public void enqueue(int val){
        stack.push(val);
    }

    public int dequeue(){
        fillHelperStackWithStack();
        int val = helperStack.pop();
        fillStackWithHelperStack();
        return val;
    }

    public int peek(){
        fillHelperStackWithStack();
        int val = helperStack.peek();
        fillStackWithHelperStack();
        System.out.println(val);
        return val;
    }

    public void printQueue(){
        if (stack.empty()){
            return;
        }

        fillHelperStackWithStack();
        Object[] list = helperStack.toArray();
        for (Object o: list) {
            System.out.print(o);
        }
        System.out.println();
        fillStackWithHelperStack();
    }

    //Make the helperStack as queue of stack
    private void fillHelperStackWithStack() {
        while (!stack.isEmpty()){ //Make the helperStack as queue of stack
            helperStack.push(stack.pop());
        }
    }

    //Return stack to the original state
    private void fillStackWithHelperStack() {
        while (!helperStack.isEmpty()){
            stack.push(helperStack.pop());
        }
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
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
