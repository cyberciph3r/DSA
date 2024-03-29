//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends

class Solution {
    int maxLen(int[] arr, int n)
    {
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i]==0){
                arr[i] = -1;
            }
        }
        int curSum = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxL = 0;
        int sum = 0;
        hm.put(0,-1);
        for(int i = 0 ; i < n ;i++){
            curSum+=arr[i];
            if(hm.containsKey(curSum-sum)){
                int start = hm.get(curSum-sum);  // sum = 0
                int end = i;
                maxL = Math.max(maxL,end-start);
            }else{
                hm.put(curSum,i);
            }
        }
        
        return maxL;
    }
}
