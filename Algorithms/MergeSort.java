import java.util.Scanner;

public class MergeSort {
	public static void print(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void mergesort(int[] arr,int start,int end) {
		int mid = (start+end)/2;
		
		//Base Case
		if(start>=end) return;
		
		//Recursion
		mergesort(arr,0,mid);
		mergesort(arr,mid+1,end);
		merge(arr,start,end);
	}
	
	public static void merge(int[] arr,int start,int end) {
		int mid = (start+end)/2;
		int[] ans = new int[(end-start)+1];
		int i=start;
		int j=mid+1;
		int index = 0;
		while(i<mid+1 && j<end+1) {
			if(arr[i]<arr[j]) ans[index++] = arr[i++];
			else ans[index++] = arr[j++];
		}
		while(i>mid && index<ans.length) {
			ans[index++] = arr[j++];
		}
		
		while(j>end && index<ans.length) {
			ans[index++] = arr[i++];
		}
		//Copying all element from ans to arr
		for(int k=0;k<ans.length;k++) {
			arr[start+k] = ans[k];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		mergesort(arr,0,arr.length-1);
		print(arr);
	}
}

//Test-Cases
//Sample Input 1 :
//6 
//2 6 8 5 4 3
//Sample Output 1 :
//2 3 4 5 6 8
//Sample Input 2 :
//5
//2 1 5 2 3
//Sample Output 2 :
//1 2 2 3 5 
