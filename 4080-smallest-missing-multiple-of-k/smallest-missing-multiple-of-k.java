class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> mul=new HashSet<>();
        for(int num:nums){
            mul.add(num);
        }
        int res=k;
        while(mul.contains(res)){
            res+=k;
        }
        return res;
    }
}