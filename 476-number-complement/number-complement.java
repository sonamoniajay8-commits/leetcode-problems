class Solution {
    public int findComplement(int num) {
        // int n=1;
        // while(n<=num){
        //     n=n<<1;
        // }
        // n=n-1;
        // int ans=num^n;
        // return ans;
        int mask = Integer.highestOneBit(num) * 2 - 1;
        return num ^ mask;
    }
}