package _Pts.A_variablesDataTypes;

public class B_IntegerCaching {
    public static void main(String[] args) {
        // Integer caching is a technique used in Java to improve performance by reusing
        // immutable objects instead of creating new ones.
        // The Integer class caches integer objects for values between -128 and 127.
        // This means that if you create an Integer object with a value in this range,
        // it will return the same object reference for the same value.

        Integer i1 = 100;
        Integer i2 = 100;

        System.out.println(i1 == i2); // true, because both refer to the same cached object

        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i3 == i4); // false, because both refer to different objects outside the cache range
        // so use .equals() method to compare the values of Integer objects
        System.out.println(i3.equals(i4)); // true, because both have the same value
    }
}
