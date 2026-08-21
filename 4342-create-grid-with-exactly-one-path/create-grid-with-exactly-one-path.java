class Solution {
    public String[] createGrid(int m, int n) {
        // Single row
        if (m == 1) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            return new String[]{new String(row)};
        }

        // Single column
        if (n == 1) {
            String[] ans = new String[m];
            for (int i = 0; i < m; i++) {
                ans[i] = ".";
            }
            return ans;
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '#');

            if (i == 0) {
                for (int j = 0; j < n - 1; j++) {
                    row[j] = '.';
                }
            } else if (i == 1) {
                row[n - 2] = '.';
                row[n - 1] = '.';
            } else {
                row[n - 1] = '.';
            }

            ans[i] = new String(row);
        }

        return ans;
    }
}