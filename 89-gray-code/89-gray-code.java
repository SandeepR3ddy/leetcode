class Solution {
    public List<Integer> grayCode(int n) {
        
        if(n == 1)
        {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(1);
            return ans;
        }
        
        List<Integer> recres = grayCode(n-1);
        
        List<Integer> myres = new ArrayList<>();
        
        
        for(int val : recres)
        {
            myres.add(val);
        }
        
        for(int i = recres.size()-1;i >= 0;i--)
        {
            int value = recres.get(i);
            
            int mask = (1 << (n-1));
            
            myres.add((value|mask));
        }
        return myres;
        }
}