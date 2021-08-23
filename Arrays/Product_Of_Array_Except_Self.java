Problem Link: https://leetcode.com/problems/product-of-array-except-self/
Time Complexity: O(N)

//Using Extra Space 

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] output = new int[n];
        
        left[0] = 1;
        right[n-1] = 1;
        
        //Calculating left value
        for(int i=1;i<n;i++){
            left[i] = nums[i-1]*left[i-1];
        }
        
        //Calculating the right value
        for(int i=n-2;i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }
        
        //Calculating output
        for(int i=0;i<n;i++){
            output[i] = left[i]*right[i];
        }
        return output;
    }
}

//Without using Extra Space

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] output = new int[n];
        
        output[0] = 1;
        //Storing left value in output itslef
        for(int i=1;i<n;i++){
            output[i] = nums[i-1] * output[i-1];
        }
        
        //Calculating right value in output
        int r = 1;
        for(int i=n-1;i>=0;i--){
            output[i] = output[i]*r;
            r=r*nums[i];
        }
        
        return output;
    }
}
