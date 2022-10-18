class Solution {
    
    static int[] parent;
    
    public int findParent(int u)
    {
        return parent[u] == u ? u : (parent[u] = findParent(parent[u]));
    }
    
    public boolean isSimilar(String str1, String str2)
    {
        int count = 0;
        
        for(int i = 0;i < str1.length();i++)
        {
           if(str1.charAt(i) != str2.charAt(i) && ++count > 2)
           {
               return false;
           }
        
        }
        
        return true;
        
    }
    
    
    public int numSimilarGroups(String[] strs) {
    
        int n = strs.length;
        
       parent = new int[n];
        
        for(int i = 0;i < n;i++)
        {
            parent[i] = i;
        }
        
        int count = n;
        
        for(int i = 0; i < n;i++)
        {
            for(int j = i+1;j < n;j++)
            {
                if(isSimilar(strs[i], strs[j]))
                {
                   int p1 = findParent(i);
                    int p2 = findParent(j);
                    
                    if(p1 != p2)
                    {
                        parent[p1] = p2;
                        count--;
                    }
                
                }
            }
        }
        
        return count;
    }
}