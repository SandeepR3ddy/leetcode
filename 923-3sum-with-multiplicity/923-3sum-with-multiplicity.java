class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
       Map<Integer,Integer> map = new HashMap<>();

        long res = 0;
        int m = 1000000007;
        
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()){
            for(int j:map.keySet()){
                int x = target - i - j;
                if(map.containsKey(x)){
                    long c1 = map.get(i),c2=map.get(j),c3=map.get(x);
                    if(i==j && j==x){
                        res += c1*(c1-1)*(c1-2)/6;
                    }
                    else if(i==j){
                        res += c1*(c1-1)/2*c3;
                    }
                    else if (i<j && j<x){
                        res += c1*c2*c3;
                    }
                }
                res = res%m;
            }
        }
        
        return (int)res;
    }
}