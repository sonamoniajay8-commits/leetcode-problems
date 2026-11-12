class Solution {
    public int longestMonotonicSubarray(int[] nums) {
       
        int max = 1;
        int inc = 1;
        int dcr = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dcr = 1; 
            } else if (nums[i] < nums[i - 1]) {
                dcr++;
                inc = 1; 
            } else {
                inc = 1;
                dcr = 1;
            }

            max = Math.max(max, Math.max(inc, dcr));
        }

        return max;
    }
}