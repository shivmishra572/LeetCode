class Solution {
    public String Reverse(String s){
        StringBuffer sc = new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            sc.append(s.charAt(i));
        }
        return sc.toString();
    }
    
    public String reverseWords(String s) {
        StringBuffer ans = new StringBuffer();
        int i=0;
        int j=0;
        while(j<s.length()){
            if(s.charAt(j)==' '){
                ans.append(Reverse(s.substring(i,j)));
                ans.append(' ');
                i=j+1;
            }
            j++;
        }
        //Reversing last word and appending it
        ans.append(Reverse(s.substring(i,j)));

        return ans.toString();
    }
}
