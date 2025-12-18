package I_ArrayLists;

import java.util.ArrayList;

//find the container with most water  
//i.e finding the two walls that can store most of the water between them      

public class E_CntMstWtr {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(8);
        lst.add(6);
        lst.add(2);
        lst.add(5);
        lst.add(4);
        lst.add(8);
        lst.add(3);
        lst.add(7);
        // starting with the first wall and last wall
        Integer i = 0;
        Integer j = lst.size() - 1;
        Integer maxWater = 0;
        // loop repeats till the first wall is before the last wall
        while (i < j) {
            // height into breadth
            Integer curWater = Math.min(lst.get(i), lst.get(j)) * (j - i);
            maxWater = Math.max(curWater, maxWater);
            // trying to upgrade the smallest height ones to the bigger ones
            // thus it can help in increaseing the water capcity
            if (lst.get(i) < lst.get(j)) {
                i++;
            } else
                j--;
        }
        System.out.println("max Capacity : " + maxWater);
    }
}
