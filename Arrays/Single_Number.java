// Hint :- This approach uses 2 properties of XOR:
// 1. XOR of a number with itself is 0.
// 2. XOR of a number with 0 is number itself.

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            ans = ans^nums[i];
        }
        return ans;
    }
}
