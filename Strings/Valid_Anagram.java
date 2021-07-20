class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        int[] freq = new int[26];
        
        for(int i=0;i<s.length();i++){
            freq[(int)(s.charAt(i)-97)]+=1;
        }
        for(int i=0;i<t.length();i++){
            freq[(int)(t.charAt(i)-97)]-=1;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}
