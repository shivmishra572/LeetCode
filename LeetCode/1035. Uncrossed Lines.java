Approach No : 1 (Memoization)

```
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        fill(dp,-1);
        return maxNum(nums1,nums2,0,0,dp);
    }
    public int maxNum(int[] s,int[] t,int i,int j,int[][] dp){
        if(i == s.length || j == t.length) return dp[i][j] = 0;
        
        if( dp[i][j] != -1) return  dp[i][j];
        
        if(s[i] == t[j]){
            return  dp[i][j] = maxNum(s,t,i+1,j+1,dp)+1;
        }
        else{
            return  dp[i][j] = Math.max(maxNum(s,t,i+1,j,dp),maxNum(s,t,i,j+1,dp));
        }
    }
    public void fill(int[][] dp,int filler){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j] = filler;
            }
        }
    }
}
```

Approach No: 2 (Tabulation)

```
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        return Tabulation(nums1,nums2,dp);
    }
    public int Tabulation(int[] s,int[] t,int[][] dp){
        for(int i=s.length;i>=0;i--){
            for(int j=t.length;j>=0;j--){
                if(i == s.length || j == t.length){
                   dp[i][j] = 0;
                    continue;
                }
                if(s[i] == t[j]){
                    dp[i][j] = dp[i+1][j+1]+1;//maxNum(s,t,i+1,j+1,dp)+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j+1]); 
                }
            }
        }
        return dp[0][0];
    }
}
```

Thank you !!
