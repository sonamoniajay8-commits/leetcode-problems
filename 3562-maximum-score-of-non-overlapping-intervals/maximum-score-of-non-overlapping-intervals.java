import java.util.*;

class Solution {
    static class Interval {
        int l, r, weight, id;

        Interval(int l, int r, int weight, int id) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.id = id;
        }
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> it = intervalsList.get(i);
            intervals[i] = new Interval(it.get(0), it.get(1), it.get(2), i);
        }

        // Sort primarily by right endpoint 'r', break ties by 'l'
        Arrays.sort(intervals, (a, b) -> {
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.l, b.l);
        });

        // Precompute largest j < i such that intervals[j].r < intervals[i].l
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int target = intervals[i].l;
            int low = 0, high = i - 1, best = -1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (intervals[mid].r < target) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            prev[i] = best;
        }

        // dp[k][i + 1] holds the optimal State picking k intervals from prefix 0..i
        State[][] dp = new State[5][n + 1];

        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < n; i++) {
                // Option 1: Skip current interval
                State best = dp[k][i];

                // Option 2: Take current interval
                int p = prev[i];
                if (k == 1) {
                    State take = new State(intervals[i].weight, new int[]{intervals[i].id});
                    best = compare(best, take);
                } else if (dp[k - 1][p + 1] != null) {
                    State prevChoice = dp[k - 1][p + 1];
                    int[] newIndices = new int[k];
                    System.arraycopy(prevChoice.indices, 0, newIndices, 0, k - 1);
                    newIndices[k - 1] = intervals[i].id;
                    Arrays.sort(newIndices);

                    State take = new State(prevChoice.score + intervals[i].weight, newIndices);
                    best = compare(best, take);
                }

                dp[k][i + 1] = best;
            }
        }

        // Select the globally optimal choice among 1 to 4 intervals
        State bestGlobal = null;
        for (int k = 1; k <= 4; k++) {
            bestGlobal = compare(bestGlobal, dp[k][n]);
        }

        return bestGlobal == null ? new int[0] : bestGlobal.indices;
    }

    private State compare(State a, State b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }
        for (int i = 0; i < Math.min(a.indices.length, b.indices.length); i++) {
            if (a.indices[i] != b.indices[i]) {
                return a.indices[i] < b.indices[i] ? a : b;
            }
        }
        return a.indices.length <= b.indices.length ? a : b;
    }
}