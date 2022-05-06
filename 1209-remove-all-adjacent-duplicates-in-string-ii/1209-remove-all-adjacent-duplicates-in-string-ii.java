class Solution {
    public String removeDuplicates(String s, int k) {
        int i=0,n = s.length();
        int[] count = new int[n];
        char[] c = s.toCharArray();
        for(int j=0;j<n;i++,j++){
            c[i] = c[j];
            count[i] = (i>0 && c[i-1] == c[j]) ? count[i-1]+1 : 1;
            if(count[i] == k){
                i -= k;
            }
        }
        return new String(c,0,i);
    }
}