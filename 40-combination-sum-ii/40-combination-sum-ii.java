class Solution {
     
    public void combinationSum2(int[] candidates, int target,int idx,List<List<Integer>> ans, List<Integer> smallans) {
      
        if(target == 0)
        {
           List<Integer> base = new ArrayList<>(smallans);
          
            ans.add(base);
            
            return;
                
        }
        
        int prev = -1;
                  
        for(int i = idx;i < candidates.length;i++)
        {
            if(prev != candidates[i] && target - candidates[i] >= 0)
            {
                
                smallans.add(candidates[i]);
                
                combinationSum2(candidates,target - candidates[i],i+1,ans,smallans);
                
                smallans.remove(smallans.size()-1);
                
            }
            
            prev = candidates[i];
            
        }
        return;   
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
      Arrays.sort(candidates);  
        
      List<List<Integer>> ans = new ArrayList<>();
        
      List<Integer> smallans = new ArrayList<>();  
        
      combinationSum2(candidates,target,0,ans,smallans);  
        
        return ans;
        
    }
}