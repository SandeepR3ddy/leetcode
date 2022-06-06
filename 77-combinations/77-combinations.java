class Solution {
    
    public void solve(int n, int k, List<Integer> smallans, List<List<Integer>> ans)
    {   
        if(k == 0)
        {
            List<Integer> temp = new ArrayList<>(smallans);
            ans.add(temp);
            return;
        }
        
        smallans.add(n);
        solve(n-1, k-1, smallans, ans);
        smallans.remove(smallans.size()-1);
        
        if(n > k)
        {
            solve(n-1,k,smallans,ans);
        }
        
    }
    
    
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> smallans = new ArrayList<>();
        
        solve(n,k,smallans,ans);
        
        return ans;
    }
}