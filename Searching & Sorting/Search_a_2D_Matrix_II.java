Approach No 1:-
  
Brute Force
Time Complexity: O(MLogN)


class Solution {
    
    public boolean binarySearch(int[][] matrix,int target,int row){
        
        int start = 0;
        int end = matrix[row].length-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(matrix[row][mid] == target){
                return true;
            }
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
        boolean ans = false;
        for(int i=0;i<matrix.length;i++){
            ans = binarySearch(matrix,target,i);
            if(ans){
                return true;
            }
        }
        return false;
    }
}

Approach No 2:-
Optimized
Time Complexity : O(N+M)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int cols = matrix[row].length-1;
        
        while(row < matrix.length && cols >= 0){ 
            
            int corner = matrix[row][cols];
            
            if(corner == target) return true;
            else if(corner>target){
                cols--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}
