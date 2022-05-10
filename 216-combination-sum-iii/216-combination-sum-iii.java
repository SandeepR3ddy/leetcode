class Solution {
    
    public void combinationSum3(int k,int target, int idx,List<Integer> smallans, List<List<Integer>> ans)
    {
        if(k == 0)
        {
            if(target == 0)
            {
          List<Integer> base = new ArrayList<Integer>(smallans);  
            
          ans.add(base);
            
          return;
            }
        }
        
        for(int i = idx;i <= 9;i++)
        {
                smallans.add(i);
                combinationSum3(k-1,target-i,i+1,smallans,ans);
                smallans.remove(smallans.size()-1);
        }
        return;
    }
    
    public List<List<Integer>> combinationSum3(int k, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> smallans = new ArrayList<>();
        
        // boolean[] used = new boolean[10];
        
        combinationSum3(k, target,1, smallans, ans);
        
        return ans;
    }
}