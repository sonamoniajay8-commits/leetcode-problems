class Solution {
    public int minimumPushes(String word) {
       int l=word.length();
       if(l<=8){
        return l;
       } else if(l<=16){
        return 8+(l-8)*2;
       }else if(l<=24){
        return 24+(l-16)*3;
       }else{
        return 48+(l-24)*4;
       }
    }
}