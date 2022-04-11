class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
      int r = grid.length;
        int c = grid[0].length;
        k= k% (r*c);
        while(k-->0){
            int last = grid[r-1][c-1];
            for(int i=r-1;i>=0;i--){
                for(int j=c-1;j>=0;j--){
                    if(i==0 && j==0) grid[i][j]=last;
                    else if( i!=0 && j==0) grid[i][j]=grid[i-1][c-1];
                    else grid[i][j] = grid[i][j-1];
                }
            }
           
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        return (List)Arrays.asList(grid);
    }
}