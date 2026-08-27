class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        boolean a[]=new boolean[n];
        for(int i=0;i<n;i++){
            a[i]=false;

        }
        for(int num:nums){
            if(num>0&&num<=n){
                a[num-1]=true;

            }
        }
        for(int i=0;i<n;i++){
            if(!a[i]){
                return i+1;
            }
        }
        return n+1;
    }
}