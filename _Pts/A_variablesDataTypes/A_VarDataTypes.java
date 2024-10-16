package _Pts.A_variablesDataTypes;

public class A_VarDataTypes {
    // datatype which is smaller in size is converted into larger size implicitly
    // this is called widening because there is no loss of data

    // if we want to convert larger size to smaller size then we need to do explicit
    // type casting to be done
    // this is called narrowing because there is loss of data

    // if a expression contains different data types then the smaller data types are
    // converted to larger data type
    // this is called type promotion

    public static void main(String[] args) {
        // byte -> short -> int -> long -> float -> double
        // char -> int -> long -> float -> double

        int i = 'A'; // 65
        System.out.println(i);// 65
        double d = 100; // 100.0
        System.out.println(d); // 100.0
        // this is widening

        // float f = 100.0; // as every value with decimal point is by default double
        // it is lossy conv so we need to do explicit type casting
        float f = (float) 100.0; // 100.0
        System.out.println(f); // 100.0
        // ths is narrowing
        // or
        float f1 = 100.0f; // 100.0 // f or F is used to specify float value
        System.out.println(f1); // 100.0

        double l = 'c' + 33.3f; // first 'c' is converted to int (99) then added to float (type promotion)
        // then the result is converted to double (widening)
        System.out.println(l); // 132.3000030517578
    }
}
