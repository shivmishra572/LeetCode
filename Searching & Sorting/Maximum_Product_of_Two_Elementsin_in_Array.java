Problem Link : https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
Time Complexity : O(N)


class Solution {
    public int maxProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                sec_max = max;
                max = nums[i];
            }
            else if(nums[i] >= sec_max){
                sec_max = nums[i];
            }
        }
        
        return ((max-1)*(sec_max-1));
    }
}
