package Sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

    public static Integer[] insertionSort(Integer[] arr) {
        List<Integer> list = new LinkedList<>(Arrays.asList(arr)); //Using linked list because of shifting will be efficient
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(0)) {
                //Checking if current number is suppose to be first
                list.add(0, list.get(i)); //Moving the number to first position
                list.remove(i + 1);
            } else {
                // Only sort number smaller than the number on the left of it.
                // This is the part of insertion sort that makes it fast
                // if the array is almost sorted.
                if (list.get(i) < list.get(i - 1)) {
                    //find where number should go
                    for (int j = 1; j < i; j++) {
                        if (list.get(i) >= list.get(j - 1) && list.get(i) < list.get(j)) {
                            //move number to the correct spot
                            list.add(j, list.get(i));
                            list.remove(i + 1);
                        }
                    }
                }
            }
        }
        return list.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        Integer[] arr = {8, 1, 44, 3, 7, 1, 87, 0};
        Arrays.stream(insertionSort(arr)).forEach(System.out::println);
    }
}
