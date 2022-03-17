class Solution {
    public int scoreOfParentheses(String s) {
        
        Stack<Integer> st = new Stack<>();  //  have any one integer instead of (
        
        int n = s.length();
        
        int count = 0;
        
        for(int i = 0;i < n;i++)
        {
            if(s.charAt(i) == '(')
            {
                st.push(-1);
                continue;
            }
            else 
            {
                if(st.peek() == -1)
                {
                    st.pop();
                    st.push(1);
                }
                else
                {
                    int val = st.pop();
                    st.pop();
                    st.push((2*val));
                }
            }
            
            while(st.size() > 1)
            {
                int val1 = st.pop();
                int val2 = st.pop();
                
               if(val1 != -1 && val2 != -1)
               {
                   st.push((val1+val2));
               }
               else
               {
                   st.push(val2);
                   st.push(val1);
                   break;
               }
            }
        }
        return st.peek();
        
    }
}