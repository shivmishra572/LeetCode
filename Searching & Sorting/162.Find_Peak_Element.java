Approach : Binary Search
Time Complexity : O(LogN)

```
class Solution {
    public int findPeakElement(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<end){
            int mid = start + (end-start)/2;
            
            if(mid+1<=end && nums[mid]<=nums[mid+1]){
                start = mid+1;
            }
            else if(mid-1>=start && nums[mid]<=nums[mid-1]){
                end = mid-1;
            }
            else if(mid-1>=start && nums[mid]>nums[mid-1]){
                start = mid;
            }
            else if(mid+1<=end && nums[mid]>nums[mid+1]){
                end = mid;
            }
        }
        return end;
    }
}
```
