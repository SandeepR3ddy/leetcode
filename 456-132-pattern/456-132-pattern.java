class Solution {
    public boolean find132pattern(int[] nums) {
        
         Stack<Integer> st = new Stack<>();
        
         int temp = Integer.MIN_VALUE;
        
         for(int i = nums.length-1;i  >= 0;i--)
         {
             if(nums[i] < temp)
             { return true;
             }
             
             while(st.size() > 0 && nums[i] > st.peek())
             {
                 temp = st.pop();
             }
             st.push(nums[i]);
         }
return false;
        
    }
}