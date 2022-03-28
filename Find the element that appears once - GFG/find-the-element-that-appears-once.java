// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int N)
    {
          
          int low = 0;
          int high = N-1;
          
          if(N == 1)
          {
              return arr[0];
          }
          if(arr[0] != arr[1])
          {
              return arr[0];
          }
          if(arr[N-1] != arr[N-2])
          {
              return arr[N-1];
          }
          
          while(low <= high)
          {
              int mid =  low + (high-low)/2;
              
                  if(arr[mid] != arr[mid-1] && arr[mid]  != arr[mid+1])
                  {
                      return arr[mid];
                  }
                  else if(arr[mid] == arr[mid-1])
                  {
                      int leftcount = mid-low+1;
                      
                      if(leftcount % 2 == 0)
                      {
                          low = mid+1;
                      }
                      else
                      {
                          high = mid-2;
                      }
                  }
                  else
                  {
                      int rightcount = high - mid + 1;
                      
                      if(rightcount % 2 == 0)
                      {
                          high = mid-1;
                      }
                      else
                      {
                          low = mid+2;
                      }
                  }
          }
          return 0;
    }
}