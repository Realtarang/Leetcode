import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char x : s.toCharArray())
        {
            if(x == '(' || x == '{' || x == '[')
            {
                st.push(x);
            }
            else
            {
                if(st.size() == 0) return false;
                char top = st.pop();
                if((x == ')' && top != '(') || 
                    (x == '}' && top != '{') ||
                    (x == ']' && top != '['))
                    return false;
            }
        }

        return st.isEmpty();
        
    }
}