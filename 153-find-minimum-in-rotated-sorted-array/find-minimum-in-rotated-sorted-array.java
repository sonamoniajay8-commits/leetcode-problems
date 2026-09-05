class Solution {
    public int findMin(int[] nums) {
       // int n=nums.length;
        Arrays.sort(nums);
        return nums[0];
    }
}