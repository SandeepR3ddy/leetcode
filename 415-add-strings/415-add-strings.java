class Solution {
    public String addStrings(String num1, String num2) {
        
        int len1 = num1.length();
        int len2 = num2.length();
        
        int i = len1-1, j = len2-1, carry = 0;
        
        StringBuilder sb = new StringBuilder("");
        
        while(i >= 0 || j >= 0 || carry != 0)
        {
            int val = (i >= 0 ? (num1.charAt(i)-'0'):0) + (j >= 0 ? (num2.charAt(j)-'0'):0) + carry;
            
            char ch = (char)(val%10 +'0');
            
            carry = val/10;
            
            sb.append(ch);
            
            i--;
            j--;
            
        }
        
        return sb.reverse().toString();
        
    }
}