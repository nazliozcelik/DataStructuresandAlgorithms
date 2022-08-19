package Arrays;

import java.util.ArrayList;

public class Arrays {

    public static void findAnyItem(){
        //Find any item in an ArrayList
        ArrayList<String> everyone = new ArrayList<String>();

        everyone.add("dory");
        everyone.add("bruce");
        everyone.add("nemo");
        everyone.add("marlin");
        everyone.add("blant");

        for (int i=0; i<everyone.size(); i++){
            if(everyone.get(i) == "nemo"){
                System.out.println("Found nemo in " + i + ". index");
            }
        }

        //Solution with foraech
        for (String found: everyone) {
            if (found == "nemo"){
                System.out.println("Found nemo");
            }
        }
    }

    public static boolean containsCommonItem(String[] first, String[] second){
        //Give 2 arrays, then let user knows (true/false) whether these 2 arrays contains any common items

        for (int i=0; i< first.length; i++){
            for (int j=0; j< second.length; j++){
                if (first[i] == second[j]){
                    System.out.println("There is matched item");
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        findAnyItem();

        String[] first = {"a", "b", "c", "d"};
        String[] second = {"w", "x", "c", "z"};
        containsCommonItem(first, second);
    }
}
