/*
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Note:
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.

 Example 1:
    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

 Example 2:
    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

 Example 3:
    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */


public class Day13_RemoveKDigits {
    public static void main(String[] args){
        Day13_RemoveKDigits test = new Day13_RemoveKDigits();
        String num = "123456";
        int k = 1;
        System.out.println(test.removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        char[] digits = num.toCharArray();
        if(k >= digits.length)
            return "0";

        // Greedy logic
        // If next digit < last added digit, replace it. try to keep sequence of digits in ascending order as far as possible

        StringBuilder builder = new StringBuilder();

        for(char digit: digits){
            while(builder.length() > 0 && builder.charAt(builder.length() - 1) > digit && k > 0){
                builder.deleteCharAt(builder.length() - 1);
                k--;
            }

            builder.append(digit);
        }

        // delete leading zeros
        while(builder.length() > 1 && builder.charAt(0) == '0'){
            builder.deleteCharAt(0);
        }

        // delete leftover chars from
        for(int i = 0; i < k; i++){
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
