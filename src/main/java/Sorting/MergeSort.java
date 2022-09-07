package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static Integer[] mergeSort(Integer[] arr) {
        return mergeSort(new ArrayList<>(Arrays.asList(arr))).toArray(new Integer[0]);
    }

    public static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        // Split Array in into right and left
        List<Integer> left = arr.subList(0, arr.size() / 2);
        System.out.println("Splitting left: " + left);
        List<Integer> right = arr.subList(arr.size() / 2, arr.size());
        System.out.println("Splitting Right: " + right);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) { //Keep merging until we done with one of the sides
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        merged.addAll(left.subList(leftIndex, left.size())); //Merging all "leftovers" elements as is because we know they are sorted
        merged.addAll(right.subList(rightIndex, right.size()));
        System.out.println("Merged: " + merged);
        return merged;
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 1, 44, 3, 7, 1, 87, 0};
        Arrays.stream(mergeSort(arr)).forEach(System.out::println);
    }
}
