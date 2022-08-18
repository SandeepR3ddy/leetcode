class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
   String[] arr  = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        HashSet<String> set = new HashSet<>();
        
        for(String word : words)    
        {
            
            String str = "";
            
        for(char ch : word.toCharArray())
        {
            str = str + arr[ch-'a']+"";
            
        }
            
            System.out.println(str);
            
            set.add(str);
            
        }

        return set.size();
        
    }
}