class Solution {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                char pop = stack.pop();
                if (pop == '(' && c != ')') return false;
                if (pop == '{' && c != '}') return false;
                if (pop == '[' && c != ']') return false;
            }
        }

        return stack.size() == 0;
    }
}
