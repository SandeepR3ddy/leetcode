class Solution {
    
    public boolean dfs(List<List<Integer>> graph, int src, int[] vis, List<Integer> ans)
    {
        
        vis[src] = 1;
        
        boolean iscycle = false;
        
        for(int val : graph.get(src))
        {
            if(vis[val] == 0)
            {
               iscycle = iscycle || dfs(graph, val, vis, ans);
            }
            else if(vis[val] == 1)
            {
                return true;
            }
        }
        
        ans.add(src);
        
        vis[src] = 2;
        
        return iscycle;
        
        
        
    }
    
    public boolean solve(List<List<Integer>> graph, int n)
    {
        
        List<Integer> ans = new ArrayList<>();
        
        boolean iscycle = false;
        
        int[] vis = new int[n];
        
        for(int i = 0;i < n;i++)
        {
            if(vis[i] == 0)
            {
                
                iscycle = iscycle || dfs(graph, i, vis , ans);   
            }
        }
        
//         if(iscycle)
//         {
//             ans.clear();
//         }
        
        return !(iscycle);
        
    }
        
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
     List<List<Integer>> graph = new ArrayList<>();  
     
        for(int i = 0;i < numCourses;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        
        
     for(int[] val : prerequisites)
     {
         graph.get(val[0]).add(val[1]);   
     }
        
    return solve(graph, numCourses);   
        
    }
}