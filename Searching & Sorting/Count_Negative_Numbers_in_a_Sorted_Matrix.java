Problem Link: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

class Solution {
    public int countNegatives(int[][] grid) {
        //Brute Force
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<0) count++;
            }
        }
        return count;
        
        //Binary Search   
        int total = 0;
        for(int i=0;i<grid.length;i++){
            int start = 0;
            int end = grid[i].length-1;
            while(start<=end){
                int mid = start + (end-start)/2 ;
                if(grid[i][mid]>=0){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            total += (grid[i].length-start);
        }
        return total;
    }
}
