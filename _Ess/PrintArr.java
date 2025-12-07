package _Ess;// essentials
// the tools in this package are to be useful for other programs in this course
// like printing an array is most required tool so made one
// printing an array via for-each loop
public class PrintArr<T> {
    public static <T> void print(T[] arr) {
        for (T i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
