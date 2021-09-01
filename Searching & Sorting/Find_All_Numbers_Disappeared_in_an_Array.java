Problem Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Approach: Cycle Sort
Time Complexity : O(N)
Space Complexity : O(1)

class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        //Cycle Sort
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(i!=correct && arr[i] != arr[correct]){
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            }
            else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(j != arr[j]-1){
                list.add(j+1);
            }
        }
        return list;
    }
}
