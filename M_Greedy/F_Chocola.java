package M_Greedy;

import java.util.Arrays;
import java.util.Collections;
//chocolate with mxn dimensions is given
//you have to cut the chocolate into small squares (bytes)
//for each cut you have to pay some price (for each distinct pieces of chocolate)
//eg: if the chocolate is already cut into 3 horizontal pieces and now you want to cut it vertically
// these 3 pieces will act as 3 distinct chocolates so for cutting vertically you have to pay 3*(cost of vertical cut)
//find the minimum cost to cut all the pieces

public class F_Chocola {
    public static void main(String[] args) {
        // to sort by builtin sort method we need Integer type
        Integer[] x = { 2, 1, 3, 1, 4 };
        Integer[] y = { 4, 1, 2 };
        // idea: to cut the maximum cost line in all the directions first
        // cz if we ignore it we may have to spend k*(cost) in future for the same cut
        // so to find the maximum we sort the two directions
        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());
        int cost = 0;
        int hParts = 1;
        int vParts = 1;
        // i,j are pointers track the current position of splits in each direction
        // the splits before them are performed and after them are yet to be performed
        int i = 0, j = 0;
        // compare the maximum of two directions
        // one with maximum cost will be cut first
        while (i < x.length || j < y.length) {
            if (i >= x.length) {
                cost += hParts * y[j];
                j++;
                continue;
            }
            if (j >= y.length) {
                cost += vParts * x[i];
                i++;
                continue;
            }
            if (x[i] >= y[j]) {
                cost += vParts * x[i];
                i++;
                hParts++;
            } else {
                cost += hParts * y[j];
                j++;
                vParts++;
            }
        }
        System.out.println("minimum Cost : " + cost);
    }
}
