// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        for(int i = 0;i < n;i++)
        {
            int max = 0;
            
            for(int j = 0;j < i;j++)
            {
                if(nums[j] < nums[i])
                {
                    max = Math.max(max,dp1[j]);
                }
            }
            dp1[i] = max + 1;
        }
        for(int i = n-1;i >= 0;i--)
        {
            int max2 = 0;
            
            for(int j = i+1;j < n;j++)
            {
                if(nums[j] < nums[i])
                {
                    max2 = Math.max(max2,dp2[j]);
                }
            }
            dp2[i] = max2+1;
        }
        int omax = 0;
        for(int i = 0;i < n;i++)
        {
            omax = Math.max(omax, dp1[i] + dp2[i] - 1);
        }
        return omax;
    }
}