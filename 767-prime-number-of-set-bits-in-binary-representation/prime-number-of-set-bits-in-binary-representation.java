class Solution {
    public int countPrimeSetBits(int left, int right) {
        int prime =0b10100010100010101100;
        int count=0;
        for(int i=left;i<=right;i++){
            int bit =Integer.bitCount(i);
            if(((prime >>bit)&1)==1){
                count++;
            }
        }
        return count;
        
    }
}