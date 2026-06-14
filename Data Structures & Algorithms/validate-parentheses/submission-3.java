class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') brackets.push(c);
            else if (brackets.size() > 0) {
                char popped = brackets.pop();
                if (popped == '[' && c != ']') return false;
                if (popped == '{' && c != '}') return false;
                if (popped == '(' && c != ')') return false;
            }
            else return false;
        }

        return brackets.size() == 0;
    }
}
