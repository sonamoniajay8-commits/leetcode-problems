class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length, ans = 0;
        for (int l = 0; l < n; l++) {
            long p = 1, lv = 1;
            int g = 0;
            for (int r = l; r < n; r++) {
                long x = nums[r];
                p *= x;
                g = gcd(g, nums[r]);
                lv = lcm(lv, x);
                if (p == lv * g) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }
        return ans;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    private long gcdL(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    private long lcm(long a, long b) {
        return (a / gcdL(a, b)) * b;
    }
}