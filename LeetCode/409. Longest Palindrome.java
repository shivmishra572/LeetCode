Appraoch No : 1 (Brute-Force)
Time Complexity : O(N)

class Solution {
    //Brute-Force
    public int longestPalindrome(String s) {
        int[] temp = new int[60];
        for(int i=0;i<s.length();i++){
            temp[(int)s.charAt(i)-65] += 1;
        }
        int single = 0;
        for(int i=0;i<temp.length;i++){
            if(temp[i]>0){
                single += temp[i]%2;
            }
        }
        int total = s.length()-single;
        if(total < s.length()){
            return total+1;
        }
        return total;
    }
}
