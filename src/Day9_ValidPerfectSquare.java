/*
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Note: Do not use any built-in library function such as sqrt.

Example 1:
    Input: 16
    Output: true

Example 2:
    Input: 14
    Output: false
 */

public class Day9_ValidPerfectSquare {
    public static void main(String[] args){
        int num = 361;
        Day9_ValidPerfectSquare test = new Day9_ValidPerfectSquare();
        System.out.println(test.isPerfectSquare(num));
    }

    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
