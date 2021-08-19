Problem Link : https://leetcode.com/problems/first-bad-version/
Approach : Binary Search
Time Complexity : O(LogN)

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(isBadVersion(mid)){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return start;
    }
}
