
Approach no: 1 (Brute-Force)
Time Complexity: O(MN)

```

class Solution {
    public int specialArray(int[] nums) {
        int number = 0;
        while(number<=nums.length){
            int count = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>=number){
                    count++;
                }
            }
            if(count == number){
                return number;
            }
            number++;
        }
        return -1;
    }
}
```

Approach no: 2 (Bucket-Sort) - 100% Faster
Time Complexity: O(N)

```
class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] bucket = new int[nums.length+1];
        
        for(int num:nums){
            if(num<n){
                bucket[num] += 1;
            }
            else{
                bucket[n]+=1;
            }
        }
        
        //We will start from last
        int total = 0;
        for(int i=nums.length;i>0;i--){
            total += bucket[i];
            if(total == i){
                return i;
            }
        }
        return -1;
    }
}
```
