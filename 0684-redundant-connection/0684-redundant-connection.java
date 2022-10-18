class Solution {
    
    static int[] parent;
    static int[] size;
    
    public int findParent(int p)
    {
     return parent[p] == p ? p : (parent[p] = findParent(parent[p]));
    }
    
    public void unionFind(int p1, int p2)
    {
        if(size[p1] < size[p2])
        {
            parent[p1] = p2;
            size[p2] += size[p1];
        }
        else
        {
            parent[p2] = p1;
            size[p1] += size[p2];
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int n = edges.length + 1;
        
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0;i < n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int[] e : edges)
        {
            int u = e[0], v = e[1];
            
            int p1 = findParent(u);
            int p2 = findParent(v);
            
            if(p1 == p2)
            {
            return e;
            }
            else
            {
              unionFind(p1,p2);
            }
        }
        
//         int[] res = new int[ans.size()];
        
//         for(List<Integer> temp : ans)
//         {
//             res.add()
//         }
        return new int[2];
        
        
    }
}