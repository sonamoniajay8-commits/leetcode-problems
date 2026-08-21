class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int a[]=new int[n+1];
        a[0]= 0;
        int prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum +=gain[i];
            a[i+1]=prefixSum;
        }
        int max = a[0];
        for(int x:a){
            max = Math.max(x,max);
        }
        return max;
        
    }
}