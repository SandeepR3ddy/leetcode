class Solution {
  
    public List<Integer> solve(List<List<Integer>> graph, int n)
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
          if(ans.size() != n){
              ans.clear();
          }
        
        return ans;
    }
        
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       
     List<List<Integer>> graph = new ArrayList<>();  
     
        for(int i = 0;i < numCourses;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        
        
     for(int[] val : prerequisites)
     {
         graph.get(val[0]).add(val[1]);   
     }
        
       List<Integer> ans = solve(graph, numCourses);   
        
       Collections.reverse(ans); 
        
        
       int[] res = new int[ans.size()];
       if(ans.size() == 0)
       {
        return res;   
       }
        
        
        for(int i = 0;i < numCourses;i++)
        {
            res[i] = ans.get(i);
        }
        
        return res;
        
        
        
        
    }
}