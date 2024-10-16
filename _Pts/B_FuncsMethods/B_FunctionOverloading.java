package _Pts.B_FuncsMethods;

public class B_FunctionOverloading {
    // or method overloading

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    // float add(int a, int b) {
    // return a + b;
    // } // if return type is diff then argument list should be diff

    public static float add(float a, float b) {
        return a + b;
    }

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
