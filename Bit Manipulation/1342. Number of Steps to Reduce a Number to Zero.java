class Solution {
    public int numberOfSteps(int num) {
        if(num == 0){
            return 0;
        }
        int ans = 0;
        while(num > 0){
            ans += ((num&1) == 0)?1:2;
            num = num >> 1;
        }
        return ans-1;
    }
}
