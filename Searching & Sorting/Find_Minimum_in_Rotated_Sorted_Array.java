Problem Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Appraoch: Binary Search
Time Complexity: O(LogN)

```
class Solution {
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(mid+1 < nums.length && nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }
            if(mid-1 >= 0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid] > nums[start]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[nums.length-1] > nums[0]) return nums[0];
        return findPivot(nums);
    }
}
```
