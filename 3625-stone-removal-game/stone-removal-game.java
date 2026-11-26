class Solution {
    public boolean canAliceWin(int n) {
        int take = 10;
        boolean p1Turn = true;
        while (n >= take && take > 0) {
            n -= take;
            take--;
            p1Turn = !p1Turn;
        }
        return !p1Turn;
    }
}