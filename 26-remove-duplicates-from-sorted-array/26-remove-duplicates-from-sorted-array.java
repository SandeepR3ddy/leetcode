class Solution {
    public int removeDuplicates(int[] nums) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int val : nums)
        {
            if(st.size() > 0 && st.peek() == val)
            {
                continue;
            }
            st.push(val);
        }
        
        int n = st.size();
        
        for(int i = 0;i < n;i++)
        {
            nums[n-i-1] = st.pop();
         }
        return n;
    }
}