class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();

        int s1=0;
        String result= "";
        int start=0;
        for(int end=0;end<n;end++){
            //char ch=s.charAt(end);
            if(s.charAt(end)=='1'){
                s1++;
            }
            while(s1 > k|| (start<end && s.charAt(start)=='0')){
                if(s.charAt(start)=='1'){
                    s1--;
                }
                start++;
            }
        
            if(s1 == k){
                String current =s.substring(start,end+1);
                if(result.isEmpty() || current.length()< result.length()||(current.length() == result.length() && current.compareTo(result) < 0)){
                    result=current;
                }
            }
        }
        return result;
    }
}