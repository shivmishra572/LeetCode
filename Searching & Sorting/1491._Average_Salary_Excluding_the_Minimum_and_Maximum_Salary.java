Problem Link : https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
Time Complexity : O(N)

class Solution {
    public double average(int[] arr) {
        
        //Finding Minimum and Maximum
        int min = arr[0];
        int max = arr[0];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
            else if(arr[i] > max){
                max = arr[i];
            }
        }
        
        //Calculating Total Sum of the Salary
        double total = 0;
        for(int i=0;i<arr.length;i++){
            total += arr[i];
        }
        
        double ans = (total-(min+max))/(arr.length-2);
        
        return ans;
    }
}
