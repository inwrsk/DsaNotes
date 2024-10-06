package A_variablesDataTypes;

public class C_typePromotion {
    public static void main(String[] args) {
        // promotion in expression is always to the higher data type
        byte b = 42;
        char c = 'a';
        // byte e = b * 2; // b * 2 will be promoted to int
        // byte c = c + b; // c = c + b will not work as c + b will be promoted to int
        long l = 98;
        // int i = c + l; // c + l will be promoted to long so it will not work
        float f = c + l; // c + l will be promoted to long then widened to float
        System.out.println("Float value " + f);// 195.0

    }
}
