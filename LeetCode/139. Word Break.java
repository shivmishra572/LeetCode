Approach No : 1 (Memoization)
```
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,wordDict,0,dp);
    }
    public boolean helper(String s,List<String> wordDict,int index,int[] dp){
        if(index == s.length()) return true;
        
        if(dp[index] != -1){
            return dp[index] == 0?true:false;
        }
        
        boolean answer = false;
        for(int i=0;i<wordDict.size();i++){
            String temp = "";
            if(index+wordDict.get(i).length()-1 < s.length()){
                temp = s.substring(index,index+wordDict.get(i).length());
            }
            if(temp.equals(wordDict.get(i))){
                answer |= helper(s,wordDict,index+wordDict.get(i).length(),dp);
            }
        }
        if(answer) dp[index] = 0;
        else dp[index] = 1;
        return answer;
    }
}
```

Approach No 2 : Tabulation

```
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        return tabulation(s,wordDict,dp);
    }
    
    public boolean tabulation(String s,List<String> wordDict,boolean[] dp){
        for(int index=s.length();index>=0;index--){
            if(index == s.length()){
                dp[index]=true;
                continue;
            }
            boolean answer = false;
            for(int i=0;i<wordDict.size();i++){
                String temp = "";
                if(index+wordDict.get(i).length()-1 < s.length()){
                    temp = s.substring(index,index+wordDict.get(i).length());
                    if(temp.equals(wordDict.get(i))){
                        answer |= dp[index+wordDict.get(i).length()];
                    }
                }
            }
            dp[index] = answer;
        }
        return dp[0];
    }
}
```

**Thank You !!**
