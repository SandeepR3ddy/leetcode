class Solution {
    
    public boolean backspaceCompare(String s, String t) {
       
        Stack<Character> st1 = new Stack<>();
        
        Stack<Character> st2 = new Stack<>();
        
        
        for(char ch : s.toCharArray())
        {
            if(ch == '#')
            {
                if(st1.size() > 0)
                st1.pop();
            }
            else
            {
                st1.push(ch);
            }
        }
        
        
        for(char ch : t.toCharArray())
        {
            if(ch == '#')
            {
                if(st2.size() > 0)
                st2.pop();
            }
            else
            {
                st2.push(ch);
            }
        }
        
        int n = st1.size();
        int m = st2.size();
        
        if(n != m)
        {
            return false;
        }
        for(int i = 0;i < n;i++)
        {
            if(st1.pop() != st2.pop())
            {
                return false;
            }
        }
        
        return true;
    }
}