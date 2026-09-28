class Solution {
    public int maxDepth(String s) {
        int intial=0;
        int last=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                intial++;
                last=Math.max(last,intial);

            }else if(ch==')'){
                intial--;
            }
        }
        return last;
    }
}