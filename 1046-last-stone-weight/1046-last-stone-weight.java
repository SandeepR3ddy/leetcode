class Solution {
    public int lastStoneWeight(int[] stones) {
   
        if(stones.length == 0)
        {
            return 0;
        }
        if(stones.length == 1)
        {
            return stones[0];
        }
        
        Arrays.sort(stones);
             
        int n = stones.length;
        
        int val1 = stones[n-1];
        int val2 = stones[n-2];
        
        if(val1 == val2)
        {
        int[] newArr = new int[n-2];
        for(int i = 0;i < n-2;i++)
        {
            newArr[i] = stones[i];
        }
               return lastStoneWeight(newArr);
         }
        else
        {
        int[] newArr = new int[n-1];
        for(int i = 0;i < n-2;i++)
        {
            newArr[i] = stones[i];
        }   
            newArr[n-2] = (val1-val2);
               return lastStoneWeight(newArr);
        }
   
    }
}