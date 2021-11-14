Approach : Binary Search
Time Complexity = O(NLogM) //Suppose M is Maximum Load

```
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        //Binary Search
        int start = weights[0];
        int end = sumOf(weights);
        int ans = 0;
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(minimumDays(weights,days,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    
    //Finding total for max value
    int sumOf(int[] arr){
        int total = 0;
        for(int i=0;i<arr.length;i++){
            total +=arr[i];
        }
        return total;
    }
    
    //Finding minimum days to load all the loads
    boolean minimumDays(int[] arr,int days,int max){
        int day = 1;
        int maxLoad = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) return false;
            
            if(maxLoad+arr[i]>max){
                day +=1;
                maxLoad = arr[i];
            }
            else{
                maxLoad += arr[i];
            }
        }
        
        if(day > days){
            return false;
        }
        return true;
    }
}
```
