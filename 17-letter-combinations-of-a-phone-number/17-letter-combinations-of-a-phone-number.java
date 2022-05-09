class Solution {
    
    public void letterCombinations(String[] words,String digits, int idx, List<String> ans, String psf)
    {
        if(idx == digits.length())
        {
            ans.add(psf);
            return;
        }
        
        int val = digits.charAt(idx) - '0';
        
        String word = words[val];
        
        for(int i = 0;i < word.length();i++)
        {
           letterCombinations(words,digits,idx+1, ans, psf+ word.charAt(i)); 
        }
        return;
    }
    
    public List<String> letterCombinations(String digits) {
        
        String[] words = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0)
        {
            return ans;
        }
        
        letterCombinations(words,digits, 0, ans, "");
        
        return ans;
    }
}