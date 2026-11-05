class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count=0;
        for(int x:arr1){
            if(isValid(arr2,x,d)){
                count++;
            }
        }
        return count;  
    }
    private boolean isValid(int[] arr2,int x,int d){
        int low=0;
        int high=arr2.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(Math.abs(arr2[mid]-x)<=d){
                return false;

            }
            if(arr2[mid]<x){
                low =mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return true;
    }
}