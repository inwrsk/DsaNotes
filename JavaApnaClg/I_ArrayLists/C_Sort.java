package I_ArrayLists;

//inbuilt sort function
import java.util.ArrayList;
import java.util.Collections;
//Collection => Interface;
//Collections => Class //this should be used

public class C_Sort {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(4);
        lst.add(1);
        lst.add(2);
        lst.add(5);
        // ascending order
        Collections.sort(lst);
        System.out.println(lst);
        // descentding order
        Collections.sort(lst, Collections.reverseOrder());
        System.out.println(lst);
    }
}
