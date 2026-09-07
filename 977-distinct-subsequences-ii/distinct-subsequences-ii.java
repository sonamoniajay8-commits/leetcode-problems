class Solution {
    public int distinctSubseqII(String s) {
        int MOD= (int)1e9+7;
        long[] num=new long[26];
        long add=0;
        for(char ch:s.toCharArray()){
            long total=(1+add)%MOD;
            int id=ch-'a';
            add=(add+total-num[id]+MOD)%MOD;
            num[id]=total;
        }
        return (int)add;
        
    }
}