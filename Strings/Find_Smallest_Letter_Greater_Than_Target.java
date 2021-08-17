Problem Link : https://leetcode.com/problems/find-smallest-letter-greater-than-target/
Approach : Binary Search

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        if(letters[0]>target || letters[letters.length-1] <= target) return letters[0];
        
        //Binary Search
        int start = 0;
        int end = letters.length;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(letters[mid] == target){
                while(letters[mid+1] == target){
                    mid++;
                }
                return letters[mid+1];
            }
            else if(letters[mid] < target){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return letters[start];
    }
}

//Approach 2

 public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
