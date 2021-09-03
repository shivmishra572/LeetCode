Problem Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/

Approach: Cycle Sort
Time Complexity: O(N)
Space Complexity: O(1)

```
class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
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
        
        for(int j=0;j<arr.length;j++){
            if(j != arr[j]-1){
                list.add(arr[j]);
            }
        }
        return list;
    }
}
```
