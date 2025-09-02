package E_Oops;

// illustration of shallow and deep copy (in context of copying object)
// shallow copy:the current variables will refer to those variables in that object we trying to copy
// deep copy: end to end info is copied i.e every information will be duplicated and assigned
class Student {
    String name;
    int roll;
    int[] marks = new int[3];
    
    // shallow copy (objects will be same) you can observe marks
    // i.e just the current variables will refer to those variables in that object
    // Student (Student s){
    // name = s.name;
    // roll = s.roll;
    // for the name and roll they will not change their values if the object s's name and roll changed
    // as they are primitive data types
    // but here the marks will change if s's marks change because both pointing to same objects
    // marks = s.marks;// here the old marks array is refered
    // }
    // so we can say in shallow copy some of the data can still dependent on the object we copied

    // deep copy (end to end info is copied) you can observe marks
    // no data is dependent on the object's data after we copy
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

public class A_ShallowDeepcopy {
    public static void main(String[] args) {
        int[] marks = { 45, 48, 40 };
        Student s1 = new Student("anwar", 20, marks);
        Student s2 = new Student(s1);// deep copying s1 details to s2
        s1.marks[0] = 50;
        s1.printDetails();
        // name : anwar
        // roll : 20
        // 50 48 40
        s2.printDetails(); // still the same as s1 details no longer effect s2 because of deep copy
        // name : anwar
        // roll : 20
        // 45 48 40
    }
    // completed about shallow and deep copy
    // Now experiment about static and instance entities
    int instanceVar;
    static int staticVar;
    public void instancemethod1() { // we can access both static and instance entities in instance methods
        System.out.println("yes it is");
        instancemethod2();
        staticmethod();
        System.out.println(instanceVar);
        System.out.println(staticVar);
    }
    
    public void instancemethod2() {
        System.out.println("instance method");
    }
    
    public static void staticmethod(){// we can access only static entities
        System.out.println("static method");
        // instancemethod1(); //err
        // System.out.println(instanceVar); // err
        System.out.println(staticVar);    
        staticmethod2();
    }

    public static void staticmethod2() {
        System.out.println("static method2");
    }
}