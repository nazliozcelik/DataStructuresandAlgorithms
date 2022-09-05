package Recursion;

public class Factorial {

    public static int findFactorialRecursively(int val){
        if (val == 1) return 1;

        return val * findFactorialRecursively(val -1);
    }

    public static int findFactorialIteratively(int val){
        int ans = 1;
        for (int i =1; i<= val; i++){
            ans*=i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findFactorialRecursively(5));
        System.out.println(findFactorialIteratively(5));
    }
}
