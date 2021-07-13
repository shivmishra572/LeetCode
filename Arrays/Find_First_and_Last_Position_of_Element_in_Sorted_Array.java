Time Complexity = O(logn)

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        
        //binary search
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        
        while(start<=end){
            mid = (start+end)/2;
            
            if(nums[mid] == target){
                int first = mid;
                while(mid-1>=0 && nums[mid-1] == target){
                    first = mid-1;
                    mid--;
                }
                int last = mid;
                while(mid+1<nums.length && nums[mid+1] == target){
                    last = mid+1;
                    mid++;
                }
                ans[0] = first;
                ans[1] = last;
                return ans;
            }
            else if(target<nums[mid]){
                end=mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}
