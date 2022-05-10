// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
    {
    
    public long countFriendsPairings(int n) 
    { 
       long[] dp = new long[n+1];
     
       long mod = (long)1e9+7;
       
       for(int i = 0;i <= n;i++)
       {
           if(i <= 1)
           {
             dp[i] = 1;
             continue;
           }
           
           dp[i] = (dp[i-1]%mod + (i-1)*dp[i-2]%mod)%mod;
           
       }
       return dp[n];
    }
}    
 