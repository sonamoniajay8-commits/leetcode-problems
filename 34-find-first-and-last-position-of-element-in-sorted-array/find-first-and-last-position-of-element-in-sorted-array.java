class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        result[0] =bound(nums,target, true);
        result[1] =bound(nums,target,false);
        return result;
    }
    private int bound(int[] nums, int target,boolean first) {
       
        int low=0;
        int high=nums.length-1;
        int ans=-1;
       

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                if(first){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }

            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
}