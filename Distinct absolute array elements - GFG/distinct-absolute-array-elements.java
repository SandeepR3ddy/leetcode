// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    int distinctCount(int[] arr, int n) {
         
        int prev = Integer.MIN_VALUE;
        int next = Integer.MAX_VALUE;
        
        int count = 0;
        
        int i = 0;
        int j = n-1;
        
        
        while(i <= j)
        {
            
            if(Math.abs(arr[i]) < arr[j])
            {
                if(arr[j] != next)
                {
                    count++;
                }
                
                next = arr[j];
                j--;
            }
            else if(Math.abs(arr[i]) == arr[j])
            {
                if(Math.abs(arr[i]) != prev && arr[j]  != next)
                {
                    count++;
                }
                prev = Math.abs(arr[i]);
                next = arr[j];
                i++;
                j--;
            }
            else
            {
                if(Math.abs(arr[i]) != prev)
                {
                    count++;
                }
                prev = Math.abs(arr[i]);
                i++;
            }
        }
        return count;
        }
}
