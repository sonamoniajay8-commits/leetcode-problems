class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            int inc = dp.getOrDefault(x, 0) + 1;
            int keep = dp.getOrDefault(x - 1, 0) + 1;

            dp.put(x + 1, Math.max(dp.getOrDefault(x + 1, 0), inc));
            dp.put(x, Math.max(dp.getOrDefault(x, 0), keep));

            ans = Math.max(ans, Math.max(inc, keep));
        }
        return ans;
    }
}