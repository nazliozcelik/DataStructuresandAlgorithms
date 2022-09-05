package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static int findFibonacciRecursively(int index){
        if (index < 2) return index;

        return findFibonacciRecursively(index-1) + findFibonacciRecursively(index-2);
    }

    public static int findFibonacciIteratively(int index){
        int prev = 0, sum = 0;
        int next = 1;

        for (int i = 1; i< index; ++i){
            sum = prev + next;
            prev = next;
            next = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(findFibonacciRecursively(6));
        System.out.println(findFibonacciIteratively(6));
    }
}
