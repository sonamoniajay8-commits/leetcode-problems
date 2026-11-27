class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int pi = items[i][1];
            int bonus = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    bonus++;
                }
            }

            if (pi > budget) continue;

            int[] cur = new int[budget + 1];
            for (int b = pi; b <= budget; b++) {
                cur[b] = dp[b - pi] + 1 + bonus;
            }
            for (int b = pi * 2; b <= budget; b++) {
                cur[b] = Math.max(cur[b], cur[b - pi] + 1);
            }
            for (int b = pi; b <= budget; b++) {
                if (cur[b] > dp[b]) {
                    dp[b] = cur[b];
                }
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            if (dp[b] > ans) ans = dp[b];
        }
        return ans;
    }
}