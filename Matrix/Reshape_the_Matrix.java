//Approach 1

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int cols = mat[0].length;
        
        if(row*cols != r*c) return mat;
        
        int[] arr = new int[row*cols];
        int index = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                arr[index++] = mat[i][j];
            }
        }
        
        index = 0;
        int[][] ans = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j] = arr[index++];
            }
        }
        
        return ans;
    }
}

//Approach 2

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int cols = mat[0].length;
        
        if(row*cols != r*c) return mat;
        
        int[][] ans = new int[r][c];
        int ri=0,cj=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                ans[ri][cj++] = mat[i][j];
                if(cj>=ans[0].length){
                    cj = 0;
                    ri++;
                }
            }
        }
        
        return ans;
    }
}
