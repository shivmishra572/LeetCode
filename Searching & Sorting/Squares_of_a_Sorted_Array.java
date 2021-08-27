Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/

Appraoch 1: Two Pointer Approach
Time Complexity: O(N)

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
         //Squaring the array
        for(int i=0;i<n;i++){
            nums[i] = nums[i]*nums[i];
        }
        //Two pointer Approach
        int i=0;
        int j=n-1;
        int index = n-1;
        int[] result = new int[n];
        while(i<=j){
            if(nums[i] < nums[j]){
                result[index--] = nums[j];
                j--;
            }
            else{
                result[index--] = nums[i];
                i++;
            }
        }
        result[0] = nums[j];
        return result;
    }
}
Approach 2: Brute Force Approach
Time Complexity: O(N^2)

class Solution {
    int temp;
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i]*nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
