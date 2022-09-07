package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static Integer[] bubbleSort(Integer[] arr) {
        int temp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 1, 44, 3, 7, 1, 87, 0};
        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);
    }
}
