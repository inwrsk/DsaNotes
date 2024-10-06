package A_variablesDataTypes;

public class B_typeCasting {
    public static void main(String[] args) {
        float a = 25.999f;
        int b = (int) a; // (narrowing) (it floors the value)
        System.out.println("Float value " + a);// 25.999
        System.out.println("Int value " + b);// 25
    }
}
