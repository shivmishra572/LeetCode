// Explanation:
// Lets assume that when you encounter 1 you add 4 to sum because island have 4 side.
// whenever you encounter 1 on top side we reduce 2 because 2 sides are covered.
// similar when you encouter 1 on left side we reduce 2 because 2 sides are covered.

class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    sum+=4;
                    if(i>0 && grid[i-1][j]==1) sum-=2;
                    if(j>0 && grid[i][j-1]==1) sum-=2;
                }
            }
        }
        return sum;
    }
}
