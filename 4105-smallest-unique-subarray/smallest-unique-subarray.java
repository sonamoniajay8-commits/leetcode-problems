class Solution {
    private static final long BASE = 100003L;
    private static final long MOD = 1_000_000_007L;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] pow = new long[n + 1];
        long[] pref = new long[n + 1];
        pow[0] = 1L;
        for (int i = 0; i < n; i++) {
            pow[i + 1] = (pow[i] * BASE) % MOD;
            long val = (nums[i] % MOD + MOD) % MOD;
            pref[i + 1] = (pref[i] * BASE + val) % MOD;
        }
        int lo = 1;
        int hi = n;
        int ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUniqueOfLength(mid, n, pref, pow)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
    private boolean hasUniqueOfLength(int len, int n, long[] pref, long[] pow) {
        Map<Long, Integer> freq = new HashMap<>();
        long basePow = pow[len];

        for (int start = 0; start + len <= n; start++) {
            int end = start + len;
            long hash = (pref[end] - (pref[start] * basePow) % MOD + MOD) % MOD;
            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}