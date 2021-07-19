class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int M = 1;
		//Traveling String from right to left
        for(int i=s.length()-1;i>=0;i--){
            int temp = (int)(s.charAt(i)-64);
            sum = sum+temp*M;
			//For every new char in String M will be Multiplied by 26
            M = M*26;
        }
        return sum;
    }
}
Time Complexity : O(N)
