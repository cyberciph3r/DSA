//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        for(int i = (n/2)-1 ; i >=0 ; i--){
            heapify(arr,n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        while(i<n){
            int lar = i;
            int lc = 2*i+1;
            int rc = 2*i+2;
            if(lc<n && arr[lar]<arr[lc]){
                lar = lc;
            }
            if(rc<n && arr[lar]<arr[rc]){
                lar = rc;
            }
            
            if(lar!=i){
                swap(arr,lar,i);
                
                i = lar;
            }else{
                break;
            }
        }
    }
    public void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        buildHeap(arr,n);
        
        for(int i = n-1 ; i >0 ; i--){
            swap(arr,0,i);
            heapify(arr,i,0);
        }
    }
 }
 
 
