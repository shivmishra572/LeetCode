Problem Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Time Complexity = O(logn)

// # Approach : 1
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


// # Approach : 2
    
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] arr = {-1,-1};
        
        //If length of array is 0
        if(nums.length == 0) return arr;
        //Binary Search for Searching First position
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                arr[0] = mid;
                end = mid-1;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        
        //Binary Search for Searching Last Position
        
        start = 0;
        end = nums.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target){
                arr[1] = mid;
                start = mid+1;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return arr;
    }
}
