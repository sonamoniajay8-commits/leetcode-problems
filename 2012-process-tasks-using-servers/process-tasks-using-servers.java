class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        
        PriorityQueue<int[]> q1 = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            return Integer.compare(x[1], y[1]);
        });
        
        PriorityQueue<int[]> q2 = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return Integer.compare(x[0], y[0]);
            if (x[1] != y[1]) return Integer.compare(x[1], y[1]);
            return Integer.compare(x[2], y[2]);
        });

        for (int i = 0; i < servers.length; i++) {
            q1.offer(new int[] { servers[i], i });
        }

        int[] ans = new int[tasks.length];
        long t = 0;

        for (int j = 0; j < tasks.length; j++) {
            t = Math.max(t, j);

            while (!q2.isEmpty() && q2.peek()[0] <= t) {
                int[] curr = q2.poll();
                q1.offer(new int[] { curr[1], curr[2] });
            }

            if (q1.isEmpty()) {
                t = q2.peek()[0];
                while (!q2.isEmpty() && q2.peek()[0] <= t) {
                    int[] curr = q2.poll();
                    q1.offer(new int[] { curr[1], curr[2] });
                }
            }

            int[] item = q1.poll();
            int w = item[0];
            int idx = item[1];

            ans[j] = idx;
            q2.offer(new int[] { (int)t + tasks[j], w, idx });
        }

        return ans;
    }
}