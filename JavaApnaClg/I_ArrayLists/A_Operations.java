package I_ArrayLists;

import java.util.ArrayList;

//ArrayList is continuous memory allocation
public class A_Operations {
    public static void main(String[] args) {
        // Creating an ArrayList ()
        ArrayList<Integer> list = new ArrayList<>();

        // Adding elements to the ArrayList O(1)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        // Printing the ArrayList
        System.out.println(list);// [10, 20, 30, 40, 50]
        // Adding an element at a specific index
        list.add(2, 25);// O(n) (as elements should be shifted to right)
        System.out.println(list);// [10, 20, 25, 30, 40, 50]

        // Removing an element at a specific index O(n) (because all the elements after
        // the removed element have to be shifted)
        list.remove(2);
        System.out.println(list);// [10, 20, 30, 40, 50]

        // Getting the element at a specific index O(1)
        System.out.println(list.get(2));// 30

        // Setting the element at a specific index O(1)
        list.set(2, 35);
        System.out.println(list);// [10, 20, 35, 40, 50]

        // Size of the ArrayList O(1)
        System.out.println(list.size());// 5

        // Contains method O(n)
        System.out.println(list.contains(30));// false

        // Index of method O(n)
        System.out.println(list.indexOf(40));// 3
    }
}
