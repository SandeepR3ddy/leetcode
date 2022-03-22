class Solution {
    
    
    public boolean checkUnique(String res)
    {
        int[] arr = new int[26];
        
        int n = res.length();
        
        for(int i = 0;i < n;i++)
        {
            char ch = res.charAt(i);
            
            if(arr[ch-'a'] != 0)
            {
                return false;
            }
            
            arr[ch-'a']++;
        }
        return true;   
    }
    
    public int maxLength(List<String> arr,int idx,String res) {
    
        if(idx == arr.size())
        {
            boolean flag = checkUnique(res);
            if(flag == false)
            {
                return 0;
            }
            else
            {
                return res.length();
            }
        }
        
        int ans1 = 0;
        
        if(arr.get(idx).length() + res.length() <= 26)
        {
            ans1 = maxLength(arr,idx+1,(res + arr.get(idx)));
        }
        int ans2 = maxLength(arr,idx+1,res);
        
        return Math.max(ans1,ans2);
    }
    public int maxLength(List<String> arr) {
        
        return maxLength(arr,0,"");
        
    }
}