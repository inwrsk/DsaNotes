package D_BitManipulation;
// how will computer understand 1111 1010 is -6 not some big positive number?
// ans: as we know the first bit is the sign bit
// if it is 0 then it is positive number
// if it is 1 then it is negative number
// eg: normal byte size is 8 bits (it should give range from 0 to 255)
// but for representing negative numbers first bit is going to be reserved
// so it will be 7 bits (0 to 127) 
// so the range will be from -128 to 127
// EXTRA Point: if there is unsigned int val = 5;
// and if we negated it then it won't be -6 it will be 4294967290 a big positive number 
// as the first bit will also be considered as data bit

public class A_negation {
    public static void main(String[] args) {
        System.out.println(~5);// -6
        // ~0000 0101
        // 1111 1010 //this is the required answer
        // to convert binary negative value to decimal
        // twos compliment should be done i.e
        // first do one's compliment //0000 0101
        // then add 1 to it // 0000 1010 i.e 6
        // as it is negative number add - before 6
        
    }
}
