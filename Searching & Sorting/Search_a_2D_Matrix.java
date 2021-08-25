Problem Link : https://leetcode.com/problems/search-a-2d-matrix/
Approach: Binary Search
Time Complexity: O(LogN)

class Solution {
    
    public int searchRow(int[][] matrix, int target){
        int start = 0;
        int end = matrix.length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(matrix[mid][0] == target) return mid;
            
            if(mid>0 && matrix[mid][0] > target ){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return end;
    }
    
    public boolean binarySearch(int[][] matrix,int target,int row){
        
        int start = 0;
        int end = matrix[row].length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchRow(matrix,target);
        return binarySearch(matrix,target,row);
    }
}
