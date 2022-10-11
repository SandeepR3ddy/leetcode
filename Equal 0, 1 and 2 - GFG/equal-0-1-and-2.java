//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution obj = new Solution();
            System.out.println(obj.getSubstringWithEqual012(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
         int c0 = 0, c1 = 0, c2 = 0;
         
         int d01 = 0, d21 = 0;
         
         Map<String, Integer> map = new HashMap<>();
         
         String temp = (c1-c0)+"@"+(c2-c1);
         
         map.put(temp,0);
         
         int ans = 0;
         
         for(char ch: str.toCharArray())
         {
             if(ch == '0')
             {
                 c0++;
             }
             else if(ch == '1')
             {
                 c1++;
             }
             else
             {
                 c2++;
             }
             
             String res = (c1-c0)+"@"+(c2-c1);;
             
             if(map.containsKey(res) == true)
             {
                map.put(res, map.get(res)+1);
                  
                  ans += map.get(res);
             }
             else
             {
                 map.put(res, 0);
             }
             
         }
         return ans;

    }
} 