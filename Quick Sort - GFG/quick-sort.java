// { Driver Code Starts
import java.util.*;
class Sorting
{
	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    
    // Driver program
    public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

			
			new Solution().quickSort(arr,0,n-1);
			printArray(arr);
		    T--;
		}
} }// } Driver Code Ends


class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low<high){
            int pivot = partition(arr, low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
        
    }
    static void randomize(int arr[],int l , int h){
        int rand =  (int) (Math.random()*(h-l))+l;
        swap(arr,rand,l);
    }
    static int partition(int arr[], int low, int high)
    {
        int i = low;
        int j = high;
        randomize(arr,low,high);
        int pivot = arr[low];
        while(i<j){
            while(i<j && arr[i]<=pivot) i++;
            while(arr[j]>pivot) j--;
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        
        return j;
    } 
    static void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
