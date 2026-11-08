class Solution {
    public int totalMoney(int n) {
        int w=n/7;
        int d=n%7;
        int total=0;
        for(int i=0;i<w;i++){
            total+=7*(i+1)+21;
        }
        int amount=w+1;
        for(int i=0;i<d;i++){
            total+=amount+i;
        }
        return total;
        
    }
}