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
    public long countFriendsPairing(int n,long[] dp)
    {
      if(n <= 1)
      {
          return dp[n] = 1; 
      }
         
      if(dp[n] != 0)
      {
          return dp[n];
      }
         
      long mod = (long)1e9+7 ;         
         
      long single = countFriendsPairing(n-1,dp) % mod;        
         
      long pairup = (countFriendsPairing(n-2,dp)*(n-1)) % mod;
         
    return dp[n] = (single+pairup)%mod;     
         
    }
    
    
    
    public long countFriendsPairings(int n) 
    { 
       long[] dp = new long[n+1];
       
       countFriendsPairing(n,dp);
       
       return dp[n];
    }
}    
 