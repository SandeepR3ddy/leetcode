class Solution {
    
    
    public boolean solve(List<List<Integer>> graph, int n)
    {
        LinkedList<Integer> que = new LinkedList<>();
        int[] indegree = new int[n];
        
        for(List<Integer> edges: graph)
        {
            for(int v : edges)
            {
                indegree[v]++;
            }
        }
        
        for(int i = 0;i < n;i++)
        {
            if(indegree[i] == 0)
            {
                que.addLast(i);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(que.size() > 0)
        {
            int size = que.size();
            
            while(size-- > 0)
            {
                int vtx = que.removeFirst();
                
                ans.add(vtx);
                
                for(int e : graph.get(vtx))
                {
                    if(--indegree[e] == 0)
                    {
                        que.addLast(e);
                    }
                    
                }
                    
            }
        }
           return ans.size() == n;
        
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