class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(0);
            }
            else{
                int count=stack.pop();
                int cur=(count==0)?1:2*count;
                stack.push(stack.pop()+cur);
            }
        }
        return stack.pop();
    }
}