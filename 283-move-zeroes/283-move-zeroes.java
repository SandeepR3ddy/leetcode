class Solution {
    public void moveZeroes(int[] nums) {
        
        int idx =  0;
        
        int n = nums.length;
        
        int i = 0;
        
        while(i < n)
        {
            if(nums[i] != 0)
            {
                  nums[idx++] = nums[i];
            }
            i++;
        }
        while(idx < n)
        {
            nums[idx++] = 0;
        }
        return;
    }
}