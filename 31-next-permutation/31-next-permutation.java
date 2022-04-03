class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        
        int i = n-2;
        
        //iterate i till the descending order sequence is disturbed
        
        while(i >= 0 && nums[i+1] <= nums[i])
        {
            i--;
        }
        
        //now find out j index which is nums[j] is just greater than nums[i]
        
        int j = 0;
        
        if(i >= 0)
        {
         j = n-1;
        
        while(j >= 0 && nums[j] <= nums[i])
        {
            j--;
        }
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        }
        //reversing ARRAY from i+1 to end
        
        i++;
        j = n-1;
        
        while(i < j)
        {
        int tempo = nums[i];
        nums[i] = nums[j];
        nums[j] = tempo;   
            
            i++;
            j--;
        }
        return;
    }
}