//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] arr, int n) {
        int goal = n-1;
        
        for(int i = n-1 ; i>=0 ; i--){
            if(i+arr[i]>=goal){
                goal = i;
            }
        }
        
        return (goal==0)?1:0;
        
        
        // int reach = 0;
        
        // for(int i = 0 ; i < n ; i++){
        //     if(reach<i)
        //         return 0;
            
        //     reach = Math.max(reach,i+arr[i]);
        // }
        
        // return 1;
    }
};