class Solution {
    int[] parent;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        for(List<Integer> a:pairs){
            union(a.get(0),a.get(1));
        }
        Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int temp = find(i);
            map.putIfAbsent(temp,new PriorityQueue<>());
            map.get(temp).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(map.get(find(i)).poll());
        }
        return sb.toString();
    }
    public int find(int idx){
        while(parent[idx] != idx){
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
    public void union(int a,int b){
        int aP = find(a);
        int bP = find(b);
        if(aP < bP){
            parent[bP] = aP;
        }
        else{
            parent[aP] = bP;
        }
    }
}