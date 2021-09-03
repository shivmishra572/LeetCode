Problem Link: https://leetcode.com/problems/set-mismatch/

Approach: Cycle Sort
Time Complexity: O(N)
Space Complexity: O(1)

class Solution {
    public int[] findErrorNums(int[] arr) {
        
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(i!=correct && arr[i]!=arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else{
                i++;
            }
        }
        
        int[] ans = new int[2];
        for(int j=0;j<arr.length;j++){
            if(j != arr[j]-1){
                ans[0] = arr[j];
                ans[1] = j+1;
                break;
            }
        }
        return ans;
    }
}
