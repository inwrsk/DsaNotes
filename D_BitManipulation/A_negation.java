package D_BitManipulation;

public class A_negation {
    public static void main(String[] args) {
        System.out.println(~5);// -6
        // ~0000 0101
        // 1111 1010 //this is the required answer
        // to convert binary negative value to decimal
        // twos compliment should be done
        // first do one's compliment //0000 0101
        // then add 1 to it // 0000 1010 i.e 6
        // as it is negative number add - before 6
    }
}
