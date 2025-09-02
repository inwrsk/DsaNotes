package K_Stacks;

import java.util.Stack;

//we should find if there exists parenthesis more than required
//eg:((a)) => true 
//(a) => false
//take a stack 
//put the elements if they are not ")"
//if ")" this is current element
//then remove all the elements in stack till "(" this is found
//so the block will be removed
// now if there is duplicate brackets
// as we removed the block contained in between 
//now they will come side by side 
// so if we encounter () these brackets side by side in stack return true (we found duplicates)
public class _duplicateParenthesis {
    static boolean isDuplicate(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')') {
                stk.push(s.charAt(i));
            } else {
                int count = 0;
                while (!(stk.peek().equals('('))) {
                    stk.pop();
                    count++;
                }
                if (count == 0) {
                    return true;
                }
                stk.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b)+(a+(b))";
        System.out.println(isDuplicate(str));
    }
}
