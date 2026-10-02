class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] vist=new boolean[26];
        for(char ch : sentence.toCharArray()){
            vist[ch-'a'] =true;
        }
        for(boolean b: vist){
            if(!b) return false;
        }
        return true;
    }
}