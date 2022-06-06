class Solution {
 
    public void solve(int[] candidates, int tar,int idx, List<Integer> smallans, List<List<Integer>> ans)
        {   
        if(tar == 0)
        {
            List<Integer> temp = new ArrayList<>(smallans);
            ans.add(temp);
            return;
        }
         if(idx == candidates.length)
         {
             return;
         }
         
        if(tar >= candidates[idx])
        {
            smallans.add(candidates[idx]);
            solve(candidates, tar-candidates[idx], idx, smallans, ans);
            smallans.remove(smallans.size()-1);
            
        }
        solve(candidates, tar, idx+1, smallans, ans);
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> smallans = new ArrayList<>();
        
        solve(candidates,target,0,smallans,ans);
        
        return ans;
    }
}