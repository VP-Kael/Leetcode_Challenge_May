/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */

import java.util.HashMap;

public class Day1_FirstBadVersion {
    HashMap<Integer, Boolean> versionMap = new HashMap<Integer, Boolean>();

    public static void main(String[] args){
        int start = 3, end = 4;
        Day1_FirstBadVersion test = new Day1_FirstBadVersion();
        test.Initiate(start, end);
        System.out.println(test.firstBadVersion(end));
    }

    private void Initiate(int start, int end){
        for (int i=1; i<=end; i++){
            versionMap.put(i, i>=start);
        }
    }

    private boolean isBadVersion(int version){
        return (versionMap.get(version));
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int med = lo + (hi -  lo)/2;
            if (isBadVersion(med)) {
                if (med == 1 || !isBadVersion(med-1))
                    return med;
                hi = med;
            } else {
                lo = med + 1;
            }
        }
        return -1;
    }
}
