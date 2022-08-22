package Arrays;

public class ReverseString {

    public static StringBuilder reverseStrings(String word) {
        StringBuilder reversedString = new StringBuilder("");
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedString.append(word.charAt(i));
        }
        return reversedString;
    }

    //Using reverse() function
    public static StringBuilder withReverseFunc(String word){
        return new StringBuilder(word).reverse();
    }

    //Recursive Solution
    public static String recursiveReverse(String word){
        if (word.length()==0 || word == null){
            return "";
        }
        return recursiveReverse(word.substring(1)) + word.charAt(0);
    }



    public static void main(String[] args) {
        System.out.println(reverseStrings("test"));
        System.out.println(withReverseFunc("test"));
        System.out.println(recursiveReverse("test"));
    }
}
