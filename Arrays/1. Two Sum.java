Approach No : 1 (Naive Approach)
Time Complexity : O(N^2)
Space Complexity : O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}

Appraoch No : 2 (HashMap)
Time Complexity : O(N)
Space Complexity : O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target-nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }
}
