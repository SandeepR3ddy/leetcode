class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int low = 0;
        int high = letters.length - 1;
        
        int tar = (int)(target-'a');
        
        int ans = -1;
        
        while(low <= high)
        {
            int mid = (low+high)/2;
            
            int val = (int)(letters[mid]-'a');
            
            
            if(val > tar)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
               low = mid+1;    
            }
        }
        if(ans == -1)
        {
            ans = 0;
        }
        
        return letters[ans];
    }
}