class Solution {
    
public void generate(int n, int idx,int obc,int cbc,StringBuilder sb,List<String> ans)
   {
         if(2*n == idx)
         {
             ans.add((sb.toString())); 
             return; 
         }
              
         if(obc < n)
         {
             sb.append("(");
             generate(n,idx+1,obc+1,cbc,sb,ans);
             sb.deleteCharAt(sb.length()-1);
         }
          if(cbc < obc)
          {
              sb.append(")");
              generate(n,idx+1,obc,cbc+1,sb,ans);
                          sb.deleteCharAt(sb.length()-1);


          }
   }

    public List<String> generateParenthesis(int n) {
     
        List<String> ans = new ArrayList<>();

          StringBuilder sb = new StringBuilder("");            
 
         generate(n,0,0,0,sb,ans);


          return ans;
    }
}