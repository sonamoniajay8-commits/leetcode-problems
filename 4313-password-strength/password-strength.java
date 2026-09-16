class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set=new HashSet<>();
       
        // for(int i=0;i<password.length();i++){
        //     char ch=password.charAt(i);
        //     set.add(ch);

        // }
        // String s1=sb.length();
        for(char ch:password.toCharArray()){
            set.add(ch);
        }
        int sum=0;
       for(char ch:set){
            if(ch>='a'&&ch<='z'){
                sum+=1;
            }
            else if(ch>='A'&&ch<='Z'){
                sum+=2;
            }
            else if(ch>='0'&&ch<='9'){
                sum+=3;
            }
            else{
                sum+=5;
            }
        }
        return sum;
    }
}