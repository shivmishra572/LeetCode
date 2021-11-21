Approach : Two Pointer Approach
Time Complexity : O(NM)

```
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int sum = 0;
        int length = 100000;
        
        int i=0;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            
            while(sum >= target){
                length = Math.min(length,j-i+1);
                sum -= nums[i];
                i++;
            }
        }
        
        if(length < 100000){
            return length;
        }
        
        return 0;
    }
}
```
