class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> initAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            initAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            initAdj.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        assignNewParents(0, s, initAdj, lastSeen, newParent);

        List<List<Integer>> finalAdj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            finalAdj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            finalAdj.get(newParent[i]).add(i);
        }

        int[] answer = new int[n];
        computeSubtreeSizes(0, finalAdj, answer);
        return answer;
    }

    private void assignNewParents(
            int u,
            String s,
            List<List<Integer>> initAdj,
            int[] lastSeen,
            int[] newParent) {
        int ch = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[ch];

        if (prevAncestor != -1 && u != 0) {
            newParent[u] = prevAncestor;
        }

        lastSeen[ch] = u;
        for (int v : initAdj.get(u)) {
            assignNewParents(v, s, initAdj, lastSeen, newParent);
        }
        lastSeen[ch] = prevAncestor;
    }

    private int computeSubtreeSizes(int u, List<List<Integer>> finalAdj, int[] answer) {
        int size = 1;
        for (int v : finalAdj.get(u)) {
            size += computeSubtreeSizes(v, finalAdj, answer);
        }
        answer[u] = size;
        return size;
    }
}