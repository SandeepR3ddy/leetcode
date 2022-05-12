class Solution {
    
    public void permuteUnique(int[] nums, int idx ,List<Integer> smallans,List<List<Integer>> ans,boolean[] visited)
    {
        if(idx == nums.length)
        {
            List<Integer> base = new ArrayList<>(smallans);
            ans.add(base);
            return;
        }
        
        
        for(int i = 0;i < nums.length;i++)
        {
            if(i > 0 && nums[i] == nums[i-1]  && !visited[i-1])
            {
                continue;
            }
            
            if(!visited[i])
            {
                smallans.add(nums[i]);
                visited[i] = true;
                permuteUnique(nums, idx+1, smallans, ans, visited);
                visited[i] = false;
                smallans.remove(smallans.size()-1);
            }
        }
        
    }
    
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        
       List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> smallans = new ArrayList<>();
        
        Arrays.sort(nums);
        
        permuteUnique(nums, 0,smallans, ans, new boolean[nums.length]);
        
        return ans;
        
    }
}