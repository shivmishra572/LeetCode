Problem Link: https://leetcode.com/problems/spiral-matrix-ii/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int minr = 0;
        int minc = 0;
        int maxr = n-1;
        int maxc = n-1;
        
        int count = 1;
        int total = n*n;
        
        while(count<=total){
            
            //Filling the Upper side
            for(int i=minc;i<=maxc && count<=total;i++){
                ans[minr][i] = count++;
            }
            minr++;
            
            //Filling the Right side
            for(int i=minr;i<=maxr && count<=total;i++){
                ans[i][maxc] = count++;
            }
            maxc--;
            
            //Filling the Upper side
            for(int i=maxc;i>=minc && count<=total;i--){
                ans[maxr][i] = count++;
            }
            maxr--;
            
            //Filling the Upper side
            for(int i=maxr;i>=minr && count<=total;i--){
                ans[i][minc] = count++;
            }
            minc++; 
            
        }
        
        return ans;
    }
}
