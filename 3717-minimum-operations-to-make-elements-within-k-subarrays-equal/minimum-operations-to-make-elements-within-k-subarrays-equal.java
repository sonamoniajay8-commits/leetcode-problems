class Solution {
    static class OrderedMultiset {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        long sum=0;
        int size=0;

        void add(int val){
            map.put(val,map.getOrDefault(val,0)+1);
            sum+=val;
            size++;
        }

        void remove(int val){
            int count=map.get(val);
            if(count==1){
                map.remove(val);
            }else{
                map.put(val,count-1);
            }
            sum-=val;
            size--;
        }

        int pollFirst(){
            int first=map.firstKey();
            remove(first);
            return first;
        }

        int pollLast(){
            int last=map.lastKey();
            remove(last);
            return last;
        }

        int peekFirst(){
            return map.firstKey();
        }

        int peekLast(){
            return map.lastKey();
        }
    }
    public long minOperations(int[] nums, int x, int k) {
        int n=nums.length;
        long[] cost=new long[n];
        OrderedMultiset left=new OrderedMultiset();
        OrderedMultiset right=new OrderedMultiset();
        int targetLeftSize=(x+1)/2;

        for(int i=0;i<n;i++){
            if(left.size==0||nums[i]<=left.peekLast()){
                left.add(nums[i]);
            }else{
                right.add(nums[i]);
            }
            if(i>=x){
                int out=nums[i-x];
                if(left.map.containsKey(out)){
                    left.remove(out);
                }else{
                    right.remove(out);
                }
            }
            while(left.size<targetLeftSize&&right.size>0){
                left.add(right.pollFirst());
            }
            while(left.size>targetLeftSize){
                right.add(left.pollLast());
            }
            if(i>=x-1){
                long median=left.peekLast();
                long leftCost=(long)left.size*median-left.sum;
                long rightCost=right.sum-(long)right.size*median;
                cost[i]=leftCost+rightCost;
            }
        }

        long INF=(long)1e18;
        long[][] dp=new long[k+1][n+1];

        for(int j=1;j<=k;j++){
            Arrays.fill(dp[j],INF);
        }

        for(int j=1;j<=k;j++){
            for(int i=j*x;i<=n;i++){
                long skip=dp[j][i-1];
                long take=dp[j-1][i-x]+cost[i-1];
                dp[j][i]=Math.min(skip,take);
            }
        }

        return dp[k][n];
    }
}