package C_Strings;

public class A_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        // similar to string but not
        // allows to modify the string
        // sb = sb + "a"; not possible
        sb.append("abc");
        System.out.println(sb + " " + sb.getClass().getName());// abc java.lang.StringBuilder
        String str = sb.toString();
        // toString is applied on objects
        System.out.println(str + " " + str.getClass().getName());// abc java.lang.String
    }
}