package I_ArrayLists;

import java.util.ArrayList;

// experimenting with 2D arraylist
public class D_MultiDimensional {
    public static void main(String[] args) {
        ArrayList<ArrayList> bigLst = new ArrayList<>();
        // bigLst stores the references of the Arraylists
        // so it doesn't matter what is the size and type of new arraylists
        // creating character arraylist
        ArrayList<Character> charLst = new ArrayList<>();
        charLst.add('A');
        charLst.add('B');
        // creating integer arraylist
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(610000);
        intList.add(2);
        intList.add(3);
        // adding both arraylists to bigLst
        bigLst.add(charLst);
        bigLst.add(intList);
        // charLst = intList; // error can't convert from ArrayList<Integer> to
        // ArrayList<Character>
        // intList = charLst; // error can't convert from ArrayList<Character> to
        // ArrayList<Integer>
        // testing statement
        charLst = bigLst.get(1);// no error
        System.out.println(charLst);// [10000, 2, 3]
        System.out.println(bigLst);// [[A, B], [1, 2, 3]]
        // or
        for (int i = 0; i < bigLst.size(); i++) {
            ArrayList<Character> temp = bigLst.get(i);// no error for second arraylist
            // because both the arraylists are store as raw type in the bigLst
            // so java won't give error assigning that second arraylist to the character
            // arraylist
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + " ");
                // as we are not performing any datatype specific operation
                // it is not giving any error at runtime while printing the integer arraylist
            }
            System.out.println();
        }
    }
}
