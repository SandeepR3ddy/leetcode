class Solution {
    
    public void solve(List<List<Integer>> ans,int rows)
    {
       if(rows == 0 || rows == 1 )
       {
           return;
       }
       else
       {
           List<Integer> smallans = new ArrayList<>();
           solve(ans,rows-1);
           List<Integer> prev = ans.get(rows-1);     
          
           smallans.add(1);
           
           for(int i = 1;i < prev.size();i++)
           {
               smallans.add((prev.get(i) + prev.get(i-1)));
           }
           smallans.add(1);
           ans.add(smallans);
           
       }
    return;
    }
    
    public List<List<Integer>> generate(int numRows) {
    
        List<List<Integer>> ans = new ArrayList<>();
        
           List<Integer> smallans = new ArrayList<>();
           
           smallans.add(1);
        
           ans.add(smallans);
        
          if(numRows == 1)
          {
              return ans;
          }
         
          List<Integer> smallans2 = new ArrayList<>();
           
           smallans2.add(1);
        
           smallans2.add(1);
        
           ans.add(smallans2);
          
           solve(ans,numRows-1);
         
           return ans;
    }
}