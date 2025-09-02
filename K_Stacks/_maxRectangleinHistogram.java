package K_Stacks;

import java.util.Stack;

//we will be given array treat it as histogram (bar graphs)
//find the maximum possible rectangle in terms of area
// refer notes for better explanation
//every rectangle that can be formed will have a height that will be equal to bar height
// and the widht is decided by the boundaries 
// if we select a bar (element in array) the boundaries will be 
// for left boundary go in search of element which is less than it (immediate)
// similarly for right boundary
// width = rightboundary - left -1 (simply watch pattern while dry runnning)
// area = width*height
//for explanation in finding immediate boundaries refer _nxtGreaterElement.java
public class _maxRectangleinHistogram {
    // these functions for finding their left and right boundaries
    static int[] nextSmaller(int[] heights) {
        int resArr[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                resArr[i] = heights.length;
            } else {
                resArr[i] = s.peek();
            }
            s.push(i);
        }
        return resArr;
    }

    static int[] beforeSmaller(int[] heights) {
        int resArr[] = new int[heights.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                resArr[i] = -1;
            } else {
                resArr[i] = s.peek();
            }
            s.push(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int[] leftboundaries = beforeSmaller(heights);
        int[] rightboundaries = nextSmaller(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (rightboundaries[i] - leftboundaries[i] - 1) * heights[i]);
        }
        System.out.println("max Area : " + maxArea);
    }
}
