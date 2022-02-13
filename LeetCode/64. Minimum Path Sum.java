Approach No : 1 (Memoization)

```
class Solution {
    public int minPathSum(int[][] grid) {
        int DR = grid.length;
        int DC = grid[0].length;
        int[][] dp = new int[DR][DC];
        return Memoization(0,0,DR-1,DC-1,grid,dp);
    }
    
    public int Memoization(int SR,int SC,int DR,int DC,int[][] grid,int[][] dp){
        if(SR == DR && SC == DC){
            return dp[SR][SC] = grid[SR][SC];
        }
        
        if(dp[SR][SC] != 0) return dp[SR][SC];
        
        int ans1 = Integer.MAX_VALUE;
        if(SR < DR){
            ans1 = Memoization(SR+1,SC,DR,DC,grid,dp);
        }
        int ans2 = Integer.MAX_VALUE;
        if(SC < DC){
            ans2 = Memoization(SR,SC+1,DR,DC,grid,dp);
        }
        
        return dp[SR][SC] = grid[SR][SC] + Math.min(ans1,ans2);
    }
}
```

Approach No : 2 (Tabulation)

```
class Solution {
    public int minPathSum(int[][] grid) {
        int DR = grid.length;
        int DC = grid[0].length;
        int[][] dp = new int[DR][DC];
        return Tabulation(DR-1,DC-1,grid,dp);
    }
    
    public int Tabulation(int DR,int DC,int[][] grid,int[][] dp){
        
        for(int sr=DR;sr>=0;sr--){
            for(int sc=DC;sc>=0;sc--){
                if(sr == DR && sc == DC){
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }
                int ans1 = Integer.MAX_VALUE;
                if(sr < DR){
                    ans1 = dp[sr+1][sc];
                }
                int ans2 = Integer.MAX_VALUE;
                if(sc < DC){
                    ans2 = dp[sr][sc+1];
                }

                dp[sr][sc] = grid[sr][sc] + Math.min(ans1,ans2);  
            }
        }
        return dp[0][0];
    }
}
```
