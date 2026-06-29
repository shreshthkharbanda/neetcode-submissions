class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            // System.out.println("tokens[i] = " + tokens[i]);
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/") && !tokens[i].equals("*")) {
                stack.push(Integer.parseInt(tokens[i]));
                // System.out.println("1 = " + stack);
            } else {
                // System.out.println("2.1 = " + stack);
                int prev = stack.pop();
                int prev2 = stack.pop();
                int res = 0;
                if (tokens[i].equals("+")) res = prev2+prev;
                else if (tokens[i].equals("-")) res = prev2-prev;
                else if (tokens[i].equals("/")) res = prev2/prev;
                else if (tokens[i].equals("*")) res = prev2*prev;
                stack.push(res);
                // System.out.println("2.2 = " + stack + ", " + res);
            }
        }

        return stack.pop();
    }
}
