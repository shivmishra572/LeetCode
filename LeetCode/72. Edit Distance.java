Appraoch No : 1 (Memoization)

```
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        fill(dp,-1);
        return distance(word1,word2,0,0,dp);
    }
    public int distance(String s,String t,int i,int j,int[][] dp){
        if(i == s.length() && j == t.length()){
            return dp[i][j] = 0;
        }
        if(i == s.length() || j == t.length()){
            return  dp[i][j] = i == s.length()? t.length()-j : s.length()-i;
        }
        
        if(dp[i][j] != -1) return  dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)){
            return  dp[i][j] = distance(s,t,i+1,j+1,dp);
        }
        else{
            int a = distance(s,t,i,j+1,dp);
            int b = distance(s,t,i+1,j,dp);
            int c = distance(s,t,i+1,j+1,dp);
            
            return  dp[i][j] = Math.min(Math.min(a,b),c)+1;
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

Appraoch No : 2 (Tabulation)

```
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        return Tabulation(word1,word2,dp);
    }
    public int Tabulation(String s,String t,int[][] dp){
        for(int i=s.length();i>=0;i--){
            for(int j=t.length();j>=0;j--){
                if(i == s.length() && j == t.length()){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == s.length() || j == t.length()){
                    dp[i][j] = i == s.length()? t.length()-j : s.length()-i;
                    continue;
                }
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];//distance(s,t,i+1,j+1,dp);
                }
                else{
                    int a = dp[i][j+1];//distance(s,t,i,j+1,dp);
                    int b = dp[i+1][j];//distance(s,t,i+1,j,dp);
                    int c = dp[i+1][j+1];//distance(s,t,i+1,j+1,dp);

                    dp[i][j] = Math.min(Math.min(a,b),c)+1;
                }
            }
        }
        return dp[0][0];
    }
}
```
