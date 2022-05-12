class Solution {
    
    public int[][] merge(int[][] intervals) {
     
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        
        List<int[]> list = new ArrayList<>();
        
        
      for(int[] curr : intervals)
      {
          if(list.size() == 0)
          {
              list.add(curr);
          }
          else
          {
              int[] prev = list.get(list.size()-1);
              
              if(prev[1] >= curr[0])
              {
                 prev[1] = Math.max(prev[1], curr[1]);    
              }
              else
              {
                  list.add(curr);
               }
          }
      }
        
        int[][] res = list.toArray(new int[list.size()][]);
        return res;
        
    }
}