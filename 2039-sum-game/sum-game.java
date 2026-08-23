class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int half = n >> 1;
        int l=0;
        int r=0;
        int diff=0;
        for(int i = 0; i < n; ++i){
            char ch = num.charAt(i);
            if(i < half){
                if(ch == '?')  ++l;
                else diff += ch - '0';

            }else{
                if(ch == '?')  ++r;
                else diff -= ch - '0';
            }
        }
        if((l + r)%2!=0)
            return true;
            
        return diff != 9 * (r - l) >> 1;
    }
}
