class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int l=0;
        int n=nums.length;
        double temp=0.;
        double ans= Double.NEGATIVE_INFINITY;
        for(int i=0;i<n;i++){
            temp+=nums[i];
            if(i-l+1>k){
                temp-=nums[l];
                l++;
            }
            if(i-l+1==k){
                ans=Math.max(ans,temp/k);
            }
        }
        return ans;
    }
}