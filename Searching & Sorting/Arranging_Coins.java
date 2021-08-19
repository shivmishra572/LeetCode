Problem Link : https://leetcode.com/problems/arranging-coins/
Approach = Binary Search
Time Complexity : O(LogN)

class Solution {
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long mid,curr;
        
        while(start <= end){
            
            mid = start + (end-start)/2;
            curr = mid*(mid+1)/2;
            
            if(curr == n) return (int)mid;
            
            if(curr > n){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return (int)end;
    }
}
