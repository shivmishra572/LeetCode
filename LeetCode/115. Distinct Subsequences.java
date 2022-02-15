Appraoch No : 1 (Memoization)

```
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        fill(dp,-1);
        return num(s,t,0,0,dp);
    }
    
    public int num(String s,String t,int i,int j,int[][] dp){
        
        if(j == t.length()) return dp[i][j] = 1;
        if(i == s.length()) return dp[i][j] = 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            ans += num(s,t,i+1,j+1,dp);
            ans += num(s,t,i+1,j,dp);
        }
        else{
            ans += num(s,t,i+1,j,dp);
        }
        
        return dp[i][j] = ans;
    }
```

Approach No : 2 (Tabulation)

```
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        return tabulation(s,t,dp);
    }
    
    public int tabulation(String s,String t,int[][] dp){
        for(int i=s.length();i>=0;i--){
            for(int j=t.length();j>=0;j--){
                if(j == t.length()) {
                    dp[i][j] = 1;
                    continue;
                }
                if(i == s.length()) {
                    dp[i][j] = 0;
                    continue;
                }
                int ans = 0;
                if(s.charAt(i) == t.charAt(j)){
                    ans += dp[i+1][j+1];//num(s,t,i+1,j+1,dp);
                    ans += dp[i+1][j];//num(s,t,i+1,j,dp);
                }
                else{
                    ans += dp[i+1][j];//num(s,t,i+1,j,dp);
                }

                dp[i][j] = ans;   
            }
        }
        return dp[0][0];
    }
}
```
