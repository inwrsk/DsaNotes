package K_Stacks;

import java.util.Stack;

//check if the string is valid paranthesis
//using stack
public class _validParanthesis {
    static boolean isValid(String s) {
        Stack<String> stk = new Stack<>();
        String[] valid = { "{}", "()", "[]" };
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            if (c.equals("{") || c.equals("[") || c.equals("(")) {
                stk.push(c);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                if ((stk.peek() + c).equals(valid[0]) || (stk.peek() + c).equals(valid[1])
                        || (stk.peek() + c).equals(valid[2])) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{(})}[]";
        System.out.println(isValid(s));// false
    }
}
