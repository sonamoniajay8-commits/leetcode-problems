class Solution {
    public int findDuplicate(int[] nums) {
        int low=0;
        int high=nums.length-1;
       
        while(low<high){
            int mid=low+(high-low)/2;
            int ans=0;
            for(int ele:nums){
                if(ele<=mid){
                    ans++;
                }
            }
            if(ans>mid){
                high=mid;
            }
            else{
                low=mid+1;

            }
        }
        return low;
    }
}