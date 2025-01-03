package P_Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

// priority queue is a queue in which the elements are ordered based on their priority
// the element with the highest priority is removed first
// this is implemented using heap data structure
public class A_priorityQueue {
    // we can use priority queue for sorting objects also by implementing comparable
    static class student implements Comparable<student> {
        String name;
        int rank;

        student(String str, int data) {
            name = str;
            rank = data;
        }

        @Override
        // we can remove it and make our work done but having it helps in readability
        // and ensure the method is overriding something
        public int compareTo(student s2) {
            return this.rank - s2.rank;// for ascending order
        }
    }

    public static void main(String[] args) {
        // Integers
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
        PriorityQueue<Integer> pqDsc = new PriorityQueue<>(Comparator.reverseOrder());
        pqAsc.add(4);
        pqAsc.add(5);
        pqAsc.add(2);
        pqAsc.add(1);
        pqAsc.add(3);
        System.out.println("Ascending order : ");
        while (!pqAsc.isEmpty()) {
            System.out.print(pqAsc.remove() + " ");
            // Ascending order :
            // 1 2 3 4 5
        }

        pqDsc.add(4);
        pqDsc.add(5);
        pqDsc.add(2);
        pqDsc.add(1);
        pqDsc.add(3);
        int i = 1;
        int j = pqDsc.size();
        System.out.println("\nDescending order : ");
        while (i <= j) {
            System.out.print(pqDsc.peek() + " ");
            pqDsc.remove();
            i++;
            // Descending order :
            // 5 4 3 2 1
        }
        // Objects
        PriorityQueue<student> pqSAsc = new PriorityQueue<>();
        PriorityQueue<student> pqSDsc = new PriorityQueue<>(Comparator.reverseOrder());
        pqSAsc.add(new student("siva sai", 7));
        pqSAsc.add(new student("anwar", 5));
        pqSAsc.add(new student("student", 10));
        System.out.println("\nAscending order : ");
        while (!pqSAsc.isEmpty()) {
            System.out.print(pqSAsc.remove().name + " ");
            // Ascending order :
            // anwar siva sai student
        }
        pqSDsc.add(new student("siva sai", 7));
        pqSDsc.add(new student("anwar", 5));
        pqSDsc.add(new student("student", 10));
        System.out.println("\nDescending order : ");
        while (!pqSDsc.isEmpty()) {
            System.out.print(pqSDsc.remove().name + " ");
            // Descending order :
            // student siva sai anwar
        }

    }
}
