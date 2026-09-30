class Solution {
    public int[] findErrorNums(int[] nums) {
        // int n=nums.length;
        // int[] count=new int[n+1];
        // int dup=-1;
        // int missing=-1;
        // for(int num:nums){
        //     count[num]++;
        // }
        // for(int i=0;i<=n;i++){
        //     if(count[i]==2){
        //         dup=i;

        //     }else if(count[i]==0){
        //         missing=i;
        //     }
        // }
        // return new int[]{dup,missing};
        HashMap<Integer,Integer> map=new HashMap<>();
        int dup=-1;
        int missing=-1;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=1;i<=nums.length;i++){
            int freq=map.getOrDefault(i,0);
            if(freq==2){
                dup=i;
            }else if(freq==0){
                missing=i;
            }

        }
        return new int[]{dup,missing};
    }
}