class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        for (String token : tokens) {
            if (!ops.contains(token)) {
                int num = Integer.parseInt(token);
                stack.push(num);
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = 0;
                if (token.equals("+")) {
                    res = op1+op2;
                } else if (token.equals("-")) {
                    res = op1-op2;
                } else if (token.equals("*")) {
                    res = op1*op2;
                } else if (token.equals("/")) {
                    if (op2 == 0) res = 0;
                    else res = op1/op2;
                }
                stack.push(res);
            }
            // System.out.println(stack);
        }

        return stack.pop();
    }
}
