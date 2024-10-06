package A_variablesDataTypes;

public class A_widening {
    public static void main(String[] args) {
        // byte -> short -> int -> long -> float -> double
        // char -> int -> long -> float -> double

        int i = 100;
        long l = i; // no explicit type casting required (widening)
        float f = l;
        // int k = f;// explicit type casting required
        // backward conversion is not possible
        System.out.println("Int value " + i);// 100
        System.out.println("Long value " + l);// 100
        System.out.println("Float value " + f);// 100.0

        char c = 'A';
        long m = c;// no explicit type casting required (widening)
        System.out.println("Char value " + c);// A
        System.out.println("Long value " + m);// 65
    }
}
