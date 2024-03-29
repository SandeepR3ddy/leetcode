//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        if(arr[0] == 0)
        {
            arr[0] = -1;
        }
        
        int psum = arr[0];
        
        map.put(0,1);
        
        map.put(psum, 1);
        
        int count = 0;
        
        for(int i = 1;i < n;i++)
        {
            if(arr[i] == 0)
        {
            arr[i] = -1;
        }
        
            psum += arr[i];
            if(map.containsKey(psum))
            {
                count += map.get(psum);
            }
            map.put(psum, map.getOrDefault(psum, 0)+1);
        }
        return count;
        
    }
}


