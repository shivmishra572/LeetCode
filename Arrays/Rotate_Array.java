Problem Link: https://leetcode.com/problems/rotate-array/

class Solution {
    public void reverse(int[] arr,int start,int end) {
		while(start<end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start+=1;
			end-=1;
		}
	}
    
    public void rotate(int[] arr, int d) {
        int n = arr.length;
        d=d%n;
        reverse(arr,0,n-1);
		    reverse(arr,0,d-1);
		    reverse(arr,d,n-1);
    }
}
