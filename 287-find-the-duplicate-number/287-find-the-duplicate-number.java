class Solution {

    public int solve(int[] nums,int curr) //curr is the value at nums[0] 
    {
        if(curr == nums[curr])
        {
            return curr;
        }
        
        int temp = nums[curr];
        
        nums[curr] = curr;
        
        return solve(nums,temp);
    }
    public int findDuplicate(int[] nums) {
        
        //1 is by sorting and linear search
        
        // using hashset
        
        //using negative marking scheme
        //for any number we go to that nums[number] and mark it as negative
        //if ever nums[number] is already negative then dulicate is found
        
      //using array as hashmap
      //by mapping number to its nums[number]  
       //if at all nums[number] is already number then dulicate is found
        
        //array as hashmap by reccursion
        
        return solve(nums,nums[0]);
    }
}