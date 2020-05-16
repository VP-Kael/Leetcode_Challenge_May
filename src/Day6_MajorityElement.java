/*
 Given an array of size n, find the majority element.
 The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:
    Input: [3,2,3]
    Output: 3

 Example 2:
    Input: [2,2,1,1,1,2,2]
    Output: 2
 */

public class Day6_MajorityElement {
    public static void main(String[] args){
        int[] input = new int[] {1,2,2,2,4,3,3,3,1,1,1};
        Day6_MajorityElement test = new Day6_MajorityElement();
        System.out.println(test.majorityElement(input));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return majorityElement(nums, 0);
    }
    private int majorityElement(int[] nums, int start){
        int count = 1;
        int num = nums[start];
        for(int i = start+1;i<nums.length;i++){
            if(num == nums[i]) count++;
            else count--;
            if(count == 0) return majorityElement(nums,i+1);
        }
        return num;
    }
}
