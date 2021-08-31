Best Case : O(N^2)
Worst Case : O(N^2)

public class Selection_Sort {

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int largest = 0;
			for(int j=0;j<n-i;j++) {
				if(arr[j] > arr[largest]) {
					largest = j;
				}
			}
			//Swap with largest element with the last index
			int temp = arr[n-i-1];
			arr[n-i-1] = arr[largest];
			arr[largest] = temp;
		}
	}
}
