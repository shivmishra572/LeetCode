Problem Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/
Approach 1 : Brute Force -> Time Complexity : O(N).
Approach 2 : Binary Search -> Time Complexity : O(LogN).


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //Brute Force Approach
        int index = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] > arr[i]){
                index = i-1;
                break;
            }
        }
        return index;
        
        //Binary Search Approach
        int start = 0;
        int end = arr.length;
        while(start != end){
            int mid = start + (end-start)/2;
            
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }
            else if(arr[mid] > arr[mid+1]){
                end = mid;
            }
        }
        return start; 
    }
}
