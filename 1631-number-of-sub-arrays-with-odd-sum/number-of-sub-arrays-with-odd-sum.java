class Solution {
    public int numOfSubarrays(int[] arr) {
        long odd = 0;
        long even = 1;
        long curr = 0;
        long ans = 0;
        int MOD = 1000000007;
        for (int num : arr) {
            curr += num;
            if (curr % 2 == 1) {
                ans = (ans + even) % MOD;
                odd++;
            } else {
                ans = (ans + odd) % MOD;
                even++;
            }
        }
        return (int) ans;
    }
}