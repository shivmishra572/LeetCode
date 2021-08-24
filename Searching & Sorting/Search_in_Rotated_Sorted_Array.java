Problem Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
Approach: Binary Search
Time Complexity: O(LogN)

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        
        int pivot = findPivot(nums);
        
        if(pivot == -1) return binarySearch(nums,target,0,n-1);
        
        if(nums[pivot] == target) return pivot;
        
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }
    
    //Finding Pivot
    public int findPivot(int[] nums){
        int n = nums.length;
        int start = 0;
        int end = n-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(mid+1<n && nums[mid] > nums[mid+1]){
                return mid;
            }
            if(mid-1>=0 && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            
            if(nums[mid]>nums[start]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
    
    //Binary Search
    public static int binarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target) return mid;
            
            else if(target>nums[mid] ){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}
