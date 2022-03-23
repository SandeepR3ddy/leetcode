class Solution {
    public String multiply(String num1, String num2) {
        
        int l1 = num1.length();
        int l2 = num2.length();
        
        if(l1 == 1 && num1.charAt(0) == '0')
        {
            return "0";
        }
        
        if(l2 == 1 && num2.charAt(0) == '0')
        {
            return "0";
        }
        
        
        int[] res = new int[l1+l2];
        
        int i = l2-1;
        
        int pf = 0; //powerfactor
        
        
        while(i >= 0)
        {
            int ival = num2.charAt(i) - '0';
            
            int k = (l1+l2)-1-pf;
            
            int carry = 0;
            
            int j = l1-1;
            
            while(j >= 0 || carry != 0)
            {
                
                int jval = j >= 0 ? num1.charAt(j)-'0' : 0;
                j--;
                
                int val = (ival * jval) + carry + res[k];
              
                res[k] = val%10;
                
                carry = val/10;
                
                k--;
            }
            pf++;
            i--;  
        }
        
        int idx = 0;
        
        int len = l1+l2;
        
        for(;idx < len;idx++)
        {
            if(res[idx] != 0)
            {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        while(idx < len)
        {
            sb.append(res[idx] + "");
            idx++;
        }
        return sb.toString();
        }
}