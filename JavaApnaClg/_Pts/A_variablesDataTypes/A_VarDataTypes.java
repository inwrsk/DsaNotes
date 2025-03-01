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
        // increasing order of data types (widening) in terms of size

        // byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
        // char(2) -> int(4) -> long(8) -> float(4) -> double(8)
        System.out.println(Float.MAX_VALUE>Long.MAX_VALUE); // true
        System.out.println(Float.MAX_VALUE); // 3.4028235E38 // 3.4028235 * 10^38
        System.out.println(Long.MAX_VALUE); // 9223372036854775807 // 2^63 - 1
        System.out.println(Double.MAX_VALUE); // 1.7976931348623157E308 // 1.7976931348623157 * 10^308
        // why long can't hold float value even though float is smaller in size
        // because in float the decimal points can be wiped out by long (lossy)
        // why float can hold long value?
        // because float, Double stores value in scientific notation (approximation) so it can denote large values
        // but long stores exact value so it can't store large values
        // so logically float can hold large values than long
        // W I D E N I N G
        int i = 'A'; // 65
        System.out.println(i);// 65
        double d = 100; // 100.0
        System.out.println(d); // 100.0
        //Long l = 10.2f; // (lossy interms of decimal points and also float can represent large values than long)
        @SuppressWarnings("unused")
        float f2 = 299l; // (299 is long value)

        // float f = 100.0; // as every value with decimal point is by default double
        // it is lossy conv so we need to do explicit type casting
        float f = (float) 100.0; // 100.0
        System.out.println(f); // 100.0
        // ths is narrowing
        // or
        float f1 = 100.0f; // 100.0 // f or F is used to specify float value
        System.out.println(f1); // 100.0

        double l = 'c' + 33.3f; // first 'c' is converted to int (99) then to float then added 33.3f (type promotion) 
        @SuppressWarnings("unused")
        double l2 = 33.3f + 'c'; // same as above
        // then the result is converted to double (widening)
        System.out.println(l); // 132.3000030517578
    }
}
