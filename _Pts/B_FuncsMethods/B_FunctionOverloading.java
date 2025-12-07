package _Pts.B_FuncsMethods;

public class B_FunctionOverloading {
    
    // or method overloading
    // same method in different forms
    // any of the following should be changed to overload a method
    // 1. Number of arguments
    // 2. Data type of arguments
    // 3. Sequence of data type of arguments
    // Return type of method does not matter

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {// Change in Number of Arguments
        return a + b + c;
    }

    public static float add(float a, float b) { // change in datatype of arguments
        return a + b;
    }

    // float add(int a, int b) {
    // return a + b;
    // } // if return type is diff then argument list should be diff
    // reason: lets say we have both int add(int a, int b) and float add(int a, int b)
    // if we call add(3, 4) it will be ambiguous for compiler to choose which method

    public static void main(String[] args) {

        System.out.println(add(2, 0));// 2
        System.out.println(add(2, 0, 1));// 3
        System.out.println(add(2.0f, 0.0f));// 2.0
        // System.out.println(add(2.0,2));//error: reference to add is ambiguous

        // block scope
        {
            int a = 10;
            System.out.println(a); // 10
        }
        // System.out.println(a); // error: cannot find symbol
    }
}
