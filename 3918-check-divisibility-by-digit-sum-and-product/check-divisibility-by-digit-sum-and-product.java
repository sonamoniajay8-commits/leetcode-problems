class Solution {
    public boolean checkDivisibility(int n) {
        int num=n;
        int sum=0;
        int pro=1;
        while(n>0){
            int temp=n%10;
            n=n/10;
            sum+=temp;
            pro*=temp;
            
        }
        return num % (sum + pro) == 0;

        
    }
}