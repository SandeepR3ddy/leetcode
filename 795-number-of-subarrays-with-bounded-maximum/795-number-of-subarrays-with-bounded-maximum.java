class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        int si = 0, ei = 0, ans = 0, prevc = 0;
        
        int n = nums.length;
        
        while(ei < n)
        {
            if(left <= nums[ei] && nums[ei] <= right)
            {
                prevc = ei-si+1;
                ans += prevc;
            }
            else if(left > nums[ei])
            {
                ans += prevc;
            }
            else
            {
                si = ei+1;
                prevc = 0;
            }
            ei++;
        }
        return ans;
    }
}