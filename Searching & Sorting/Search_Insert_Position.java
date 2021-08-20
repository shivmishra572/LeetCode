Problem Link : https://leetcode.com/problems/search-insert-position/

//Appraoch : 1 -> Brute Force
Time Complexity : O(N)

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]-mid-1 < k){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return start+k;
    }
}

//Approach : 2 -> Binary Search 
Time Complexity : O(LogN)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) start=mid+1;
            else end = mid-1;
        }
        return start;
    }
}
