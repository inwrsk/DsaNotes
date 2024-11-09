package E_Oops;

public class A_ShallowDeepcopy {
    public static void main(String[] args) {
        int[] arr = { 45, 48, 40 };
        Student s1 = new Student("anwar", 20, arr);
        Student s2 = new Student(s1);
        s1.marks[0] = 50;
        s1.printDetails();
        // name : anwar
        // roll : 20
        // 50 48 40
        s2.printDetails();
        // name : anwar
        // roll : 20
        // 45 48 40
        // cantheclassaccess(); can't access instance methods in static
    }

    public void cantheclassaccess() {
        System.out.println("yes it is");
        func();// we can
    }

    public void func() {
        System.out.println("func");
    }

}

class Student {
    String name;
    int roll;
    int[] marks = new int[3];

    // shallow copy (objects will be same) like marks
    // Student (Student s){
    // name = s.name;
    // roll = s.roll;
    // marks = s.marks;// here the old marks array is refered
    // }

    // deep copy (new objects are created)
    Student(Student s) {
        name = s.name;
        roll = s.roll;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s.marks[i];
        }
    }

    Student(String name, int roll, int[] marks) {
        this.name = name;
        this.roll = roll;
        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = marks[i];
        }
    }

    public void printDetails() {
        System.out.println("name : " + name);
        System.out.println("roll : " + roll);
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

}
