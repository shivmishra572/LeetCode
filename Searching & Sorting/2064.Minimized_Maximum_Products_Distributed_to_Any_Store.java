Approach : Binary Search
Time Complexity : O(NLog100000)

```
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        //Binary Search
        int start = 1;
        int end = 100000;
        int ans = 0;
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            if(minimumDays(quantities,n,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    
    //Finding minimum days to load all the loads
    boolean minimumDays(int[] arr,int n,int maxProd){
        int shop = 0;
        int max = 0;
        
        int i=0;
        while(i<arr.length){
            
            if(max+maxProd > arr[i]){
                if(arr[i]-max > 0){
                    shop++;
                }
                i++;
                max = 0;
            }
            else{
                max = max+maxProd;
                shop++;
            }
        }
        
        if(shop>n){
            return false;
        }
        return true;
    }
}
```
