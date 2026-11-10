class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int cost=costs[i-1];
            int mincost=Integer.MAX_VALUE;
            for(int j=1;j<=3;j++){
                int k=i-j;
                if(k>=0){
                    mincost = Math.min(mincost, dp[k] + cost + (j * j));
                }
            }
            dp[i]=mincost;
        }
        return dp[n];
    }
}