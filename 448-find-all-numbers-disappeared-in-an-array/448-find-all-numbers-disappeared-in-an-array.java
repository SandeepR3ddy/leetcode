class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        
        List<Integer> list = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0;i < n;i++)
        {     
           set.add(nums[i]);
        }
        
        for(int i = 1;i <= n;i++)
        {
            if(set.contains(i) == false)
            {
                list.add(i);
            }
        }
        return list;
        
    }
}