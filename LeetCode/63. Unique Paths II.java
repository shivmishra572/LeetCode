Approach No 1: Memoization

```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int DR = obstacleGrid.length;
        int DC = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[DR-1][DC-1] == 1) return 0;
        int[][] paths = new int[DR][DC];
        return Memoization(0,0,DR-1,DC-1,obstacleGrid,paths);
    }
    public int Memoization(int SR,int SC,int DR,int DC,int[][] obstacle,int[][] paths){
        
        if(SR == DR && SC == DC){
            return paths[SR][SC] = 1;
        }
        
        if(paths[SR][SC] != 0) return paths[SR][SC];
        
        int ans = 0;
        
        if(SR < DR && obstacle[SR+1][SC] != 1){
            ans += Memoization(SR+1,SC,DR,DC,obstacle,paths);
        }
        if(SC < DC && obstacle[SR][SC+1] != 1){
            ans += Memoization(SR,SC+1,DR,DC,obstacle,paths);
        }

        return paths[SR][SC] = ans;
    }
}
```

Approach No 2: Tabulation (100 % Faster )

```
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int DR = obstacleGrid.length;
        int DC = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[DR-1][DC-1] == 1) return 0;
        int[][] paths = new int[DR][DC];
        return Tabulation(0,0,DR-1,DC-1,obstacleGrid,paths);
    }
    public int Tabulation(int SR,int SC,int DR,int DC,int[][] obstacle, int[][] dp){
        for(int sr=DR;sr>=0;sr--){
            for(int sc=DC;sc>=0;sc--){
                if(obstacle[sr][sc] == 1){
                    dp[sr][sc] = 0;
                    continue;
                }
                if(sr == DR && sc == DC){
                    dp[sr][sc] = 1;
                    continue;
                }
                int ans = 0;
        
                if(sr < DR){
                    ans += dp[sr+1][sc];
                }
                if(sc < DC){
                    ans += dp[sr][sc+1];
                }
                dp[sr][sc] = ans;
            }
        }
        return dp[0][0];
    }
}
```
