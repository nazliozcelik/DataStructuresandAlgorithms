package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static Integer[] quickSort(Integer[] arr, int left, int right){
        int pivot;
        int partitionIndex;

        if(left < right) {
            pivot = right;
            System.out.println("Part: " + Arrays.asList(arr).subList(left, right + 1) + " by " + arr[pivot]);
            partitionIndex = partition(arr, pivot, left, right);
            System.out.println("Result: " +  Arrays.asList(arr).subList(left, right + 1));

            //sort left and right
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public static int partition(Integer[] arr, int pivot, int left, int right){
        int pivotValue = arr[pivot];
        int partitionIndex = left;

        for(int i = left; i < right; i++) {
            if(arr[i] < pivotValue){
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(arr, right, partitionIndex);
        return partitionIndex;
    }

    private static void swap(Integer[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 1, 44, 3, 7, 1, 87, 0};
        System.out.println(Arrays.asList(quickSort(arr, 0 , arr.length - 1)));
    }
}
