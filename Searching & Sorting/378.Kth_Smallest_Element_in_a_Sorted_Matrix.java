Appraoch : 1 (Priority Queue)
Time Complexity : O(N^2);

```
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                pq.add(matrix[i][j]);
            }
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            if(i==k-1){
                ans = pq.poll();
            }
            pq.poll();
        }
        return ans;
    }
}
```

Appraoch : 2 (Binary Search)
Time Complexity : O(NLogN);

```
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix.length-1];
        int ans = 0;
        
        while(low<=high){
            
            int mid = low + (high-low)/2;
            
            int count = count(mid,matrix);
            
            if(count<k){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    
    public static int count(int mid,int[][] matrix){
        int c = 0;
        int i = matrix.length-1;
        int j = 0;

        while(i>=0 && j<matrix.length){
            int num = matrix[i][j];
            if(num>mid){
                i--;
            }
            else{
                c += i+1;
                j++;
            }
        }
        return c;
    }
}
```

Follow this video for better understanding !!
Video Link : https://youtu.be/G5wLN4UweAM
