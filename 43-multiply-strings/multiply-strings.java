class Solution {
    public String multiply(String num1, String num2) {
        // int n1=0;
        // int n2=0;
        // for(int i=0;i<num1.length();i++){
        //     n1=n1*10+(num1.charAt(i)-'0');

        // }
        // for(int i=0;i<num2.length();i++){
        //     n2=n2*10+(num2.charAt(i)-'0');
        // }
        // int product=n1*n2;
        // String result="";
        // if(product==0){
        //     result ="0";

        // }
        // else{
        //         while(product>0){
        //         int digit = product % 10;
        //             result = (char)(digit + '0') + result;
        //             product = product / 10;
        //     }
        // }
        // return result;
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        // Multiply each digit from right to left
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';
                int mul = d1 * d2;

                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p2] = sum % 10;
                pos[p1] += sum / 10;
            }
        }

        // Build the result string skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}