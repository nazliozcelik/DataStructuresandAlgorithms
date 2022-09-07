package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static Integer[] selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minValue = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]) { //Searching min value and it's index
                    minValue = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i]; //Swapping the min value found
            arr[i] = minValue;
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] array = {8, 1, 44, 3, 7, 1, 87, 0};
        Arrays.stream(selectionSort(array)).forEach(System.out::println);
    }
}
