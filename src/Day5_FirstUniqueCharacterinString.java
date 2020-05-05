/*
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples 1:
    s = "leetcode"
    return 0.

 Examples 2:
    s = "loveleetcode",
    return 2.
 */

public class Day5_FirstUniqueCharacterinString {
    public static void main(String[] args){
        Day5_FirstUniqueCharacterinString test =
                new Day5_FirstUniqueCharacterinString();
        String s = "loveleetcode";
        System.out.println(test.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        int[] cnt_arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            cnt_arr[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(cnt_arr[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
