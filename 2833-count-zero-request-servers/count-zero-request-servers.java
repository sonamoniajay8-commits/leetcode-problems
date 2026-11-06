class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
       int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[m];
        int[] freq = new int[n + 1];
        int active = 0, left = 0, right = 0;

        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int origIdx = sortedQueries[i][1];

            while (right < logs.length && logs[right][1] <= qTime) {
                if (freq[logs[right][0]]++ == 0) active++;
                right++;
            }
            while (left < logs.length && logs[left][1] < qTime - x) {
                if (--freq[logs[left][0]] == 0) active--;
                left++;
            }
            ans[origIdx] = n - active;
        }
        return ans;
    }
}