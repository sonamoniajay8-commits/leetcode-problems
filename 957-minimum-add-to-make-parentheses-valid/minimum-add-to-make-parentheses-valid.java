class Solution {
    public int minAddToMakeValid(String s) {
        int count=0;
        int need =0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }
            else{
                if(count>0){
                    count--;
                }
                else{
                    need++;
                }
            }
        }
        return count+need;
    }
}