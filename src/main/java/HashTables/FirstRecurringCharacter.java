package HashTables;

import javax.management.ObjectName;
import java.util.Arrays;
import java.util.HashSet;

public class FirstRecurringCharacter {
    //For example, we have an array, [1,2,3,4,2,5] -> it should return 2
    
    public static Object firstRecurringCharacter(Object[] arr){
        int matched = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j =1; j< arr.length; j++){
                if (arr[i].equals(arr[j])){
                    return arr[j];
                }
            }
        }
        return null;
    }

    //Another way with using HashSet
    public static Object firstRecurringCharacter2(Object[] arr){
        HashSet<Object> hashSet = new HashSet<>(Arrays.asList(arr));
        for (Object obj : arr){
            if (hashSet.contains(obj)){
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Object[] arr = {1,5,8,5,1,8,8,7,4,4,10};
        System.out.println(firstRecurringCharacter(arr));
        System.out.println(firstRecurringCharacter2(arr));
    }
}
