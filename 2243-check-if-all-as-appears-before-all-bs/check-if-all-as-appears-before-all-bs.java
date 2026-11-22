class Solution {
    public boolean checkString(String s) {
        boolean seenB = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                seenB = true;
            } else if (seenB) {
                return false;
            }
        }
        return true;
    }
}