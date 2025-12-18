package I_ArrayLists;

import java.util.ArrayList;

//swap two elements in an arraylist

public class B_Swap {

    public static void swap(ArrayList<Integer> list, Integer a, Integer b) {
        Integer temp = list.get(a);
        list.set(a, list.get(b)); // set(index, value);
        list.set(b, temp);
    }

    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        swap(lst, 0, 4);
        System.out.println(lst);// [5,2,3,4,1]
    }

}
