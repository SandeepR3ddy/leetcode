class Solution {
    public int[] productExceptSelf(int[] nums) {
     
        int n = nums.length;
       
        int curr = 1;
        
        int[] ans = new int[n];
        
        for(int i = 0;i < n;i++)
        {
            ans[i] = curr;
            curr = curr*nums[i];
        }
        
        curr = 1;
        
        for(int i = n-1;i >= 0;i--)
        {
            ans[i] *= curr;
            curr = curr*nums[i];
        }
        
        return ans;
    }
}