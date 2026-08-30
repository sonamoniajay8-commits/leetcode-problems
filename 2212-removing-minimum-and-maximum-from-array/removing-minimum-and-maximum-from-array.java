class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        if(n<=2){
            return n;   
        }
        int minidx=0;
        int maxidx=0;
        for(int i=0;i<n;i++){
            if(nums[i] < nums[minidx]){
                minidx=i;
            }
            if(nums[i]>nums[maxidx]){
                maxidx=i;
            }
        }
        int l=Math.min(minidx,maxidx);
        int r=Math.max(minidx,maxidx);
        int a=r+1;
        int b=n-l;
        int ab=(l+1)+(n-r);
        return Math.min(a,Math.min(b,ab));

    }
}