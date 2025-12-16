package C_Strings;

public class A_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        // similar to string but not
        // allows to modify the string
        sb.append("abc");
        // sb = sb + "a"; not possible
        StringBuilder s2 = sb;
        sb.deleteCharAt(sb.length() - 1);// deleting the last character
        sb.insert(sb.length(), "d");// inserting a char at the last position
        System.out.println(sb + " " + sb.getClass().getName());// abd java.lang.StringBuilder

	sb.insert(sb.length()-1, "c"); // inserts the string we give from that position and moves the other to the right side!
        String str = sb.toString();
        // toString is applied on objects
        System.out.println(str + " " + str.getClass().getName());// abcd java.lang.String
        System.out.println(s2==sb);// true even after modifying sb, cz they are pointing to same object
    }
}
