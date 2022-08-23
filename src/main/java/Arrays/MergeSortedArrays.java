package Arrays;

import java.util.stream.Stream;

import static Arrays.Arrays.*;
import static java.util.Arrays.deepToString;
import static java.util.Arrays.stream;

public class MergeSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int [] arr2){
        int[] mergedArray = new int[arr1.length + arr2.length];
        int j = 0, k = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (j != arr1.length && (k == arr2.length || arr1[j] < arr2[k])) {
                mergedArray[i] = arr1[j];
                j++;
            } else {
                mergedArray[i] = arr2[k];
                k++;
            }
        }
        return mergedArray;
    }

    //Another way
    public static String[] mergeStringObjects(){
        String[] nums1 = {"1", "3", "4"};
        String[] nums2 = {"2", "5"};
        String[] merged = Stream.concat(stream(nums1), stream(nums2))
                .sorted()
                .toArray(String[]::new);

        System.out.println(deepToString(merged));
        return merged;
    }

    public static void main(String[] args) {
        mergeStringObjects();
        int[] arr = mergeSortedArrays(new int[]{1,1,8,9,10}, new int[]{1,2,8,9,11,15,16});
        stream(arr).forEach(System.out::print);
    }
}
