Approach No: 1 (Brute Force)
Time Complexity : O(N)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i=i+2){
            if(i+1<nums.length && nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}


Approach No: 2 (Binary Search)
Time Complexity : O(LogN)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start<end){
            int mid = start + (end-start)/2;
            
            if(mid%2==0){
                if(mid+1 <= end && nums[mid] == nums[mid+1]){
                    start = mid+2;
                }
                else{
                    end = mid;
                }
            }
            else{
                if(mid-1>=start && nums[mid] == nums[mid-1]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return nums[end];
    }
}
