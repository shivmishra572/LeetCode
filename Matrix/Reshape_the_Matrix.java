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
