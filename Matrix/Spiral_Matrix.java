Problem Link : https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length-1;
        int maxc = matrix[0].length-1;
        
        int count = 1;
        int total = matrix.length*matrix[0].length;
        
        while(count<=total){
            //Travelling Upper Wall
            for(int i=minc;i<=maxc && count<=total;i++){
                ans.add(matrix[minr][i]);
                count++;
            }
            minr++;
            
            //Travelling Right Wall
            for(int i=minr;i<=maxr && count<=total;i++){
                ans.add(matrix[i][maxc]);
                count++;
            }
            maxc--;
            
            //Travelling Bottom Wall
            for(int i=maxc;i>=minc && count<=total;i--){
                ans.add(matrix[maxr][i]);
                count++;
            }
            maxr--;
            
            //Travelling Left Wall
            for(int i=maxr;i>=minr && count<=total;i--){
                ans.add(matrix[i][minc]);
                count++;
            }
            minc++;
        }
        return ans;
    }
}
