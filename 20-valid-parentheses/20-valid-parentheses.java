class Solution {
    public boolean isValid(String str) {
   Stack<Character> st = new Stack<>();
		
		for(char ch : str.toCharArray())
		{
			if(st.size() > 0)
			{
				char pr = st.peek();
				if(pr == '(' && ch == ')')
				st.pop();
				else if(pr == '{' && ch == '}')
				st.pop();
				else if(pr == '[' && ch == ']')
				st.pop();
				else
				st.push(ch);
			}
			else
				st.push(ch);
		}
		return st.size() == 0 ? true : false;
	}
}	  