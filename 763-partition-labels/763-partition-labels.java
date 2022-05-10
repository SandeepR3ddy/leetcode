class Solution {
    public List<Integer> partitionLabels(String s) {
       
        int[] arr = new int[26];
     
        for(int i = 0;i < s.length();i++)
        {
            char ch = s.charAt(i);
            arr[ch-'a'] = i;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int prev = -1;//to have length;
        
        int maxEffect = -1;
        
        for(int i = 0;i < s.length();i++)
            
        {   
            
            maxEffect = Math.max(maxEffect, arr[s.charAt(i)-'a']);
            
            
            if(maxEffect == i)
            {
                ans.add(maxEffect-prev);
                prev = maxEffect;
            }
            
        }
        return ans;
    }
}