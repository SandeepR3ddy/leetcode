// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    public static Node helper(int[] inorder,int[] preorder,int ps,int pe,int is,int ie)
     { 
             if(ps > pe || is > ie)
             {
                 return null;
             }
             
             Node root = new Node(preorder[ps]);
             
             int idx = 0;
             
             while(preorder[ps] != inorder[idx])
             {
                 idx++;
             }
             
             int k = idx-is;
             
             root.left = helper(inorder,preorder,ps+1,ps+k,is,idx-1);
             
             root.right = helper(inorder,preorder,ps+k+1,pe,idx+1,ie);
             
               return root;
    
     }
    
    
    
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
         return helper(inorder,preorder,0,n-1,0,n-1);
    }
}
