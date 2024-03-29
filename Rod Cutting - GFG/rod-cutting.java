//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        
        // Tabulation... (Buttom - Up)..Space Optimized... Using only 1D Array
        
        int prev[] = new int[n+1];
        
        for(int rodLen = 0 ; rodLen <= n ; rodLen++){
            prev[rodLen] = rodLen*price[0];
        }
        
        for(int index = 1 ; index< n ; index++){
            for(int rodLen = 0 ; rodLen <= n ; rodLen++){
                int cut = 0;
                if((index+1)<=rodLen) // index+1 = rod length
                    cut = price[index] + prev[rodLen - (index+1)];
                int notCut = 0 + prev[rodLen];
                
                prev[rodLen] = Math.max(cut,notCut);
            }
        }
        
        return prev[n];
        
        
        
        // Tabulation ...  (Buttom - Up) ...Space Optimized...
        
        // int cur[] = new int[n+1];
        // int prev[] = new int[n+1];
        
        // for(int rodLen = 0 ; rodLen <= n ; rodLen++){
        //     prev[rodLen] = rodLen*price[0];
        // }
        
        // for(int index = 1 ; index< n ; index++){
        //     for(int rodLen = 0 ; rodLen <= n ; rodLen++){
        //         int cut = 0;
        //         if((index+1)<=rodLen) // index+1 = rod length
        //             cut = price[index] + cur[rodLen - (index+1)];
        //         int notCut = 0 + prev[rodLen];
                
        //         cur[rodLen] = Math.max(cut,notCut);
        //     }
        //     prev = cur.clone();
        // }
        
        // return prev[n];
        
        
        
        
        
        // Tabulation ...  (Buttom - Up) ...
        
        // int dp[][] = new int[n][n+1];
        
        // for(int rodLen = 0 ; rodLen <= n ; rodLen++){
        //     dp[0][rodLen] = rodLen*price[0];
        // }
        
        // for(int index = 1 ; index< n ; index++){
        //     for(int rodLen = 0 ; rodLen <= n ; rodLen++){
        //         int cut = 0;
        //         if((index+1)<=rodLen) // index+1 = rod length
        //             cut = price[index] + dp[index][rodLen - (index+1)];
        //         int notCut = 0 + dp[index-1][rodLen];
                
        //         dp[index][rodLen] = Math.max(cut,notCut);
        //     }
        // }
        
        // return dp[n-1][n];
        
        
        
        
        
        
        // Memoization (Top- Down) ...
        
        // int dp[][] = new int[n][n+1];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        // return rcp(n-1,n,price,dp);
    }
    
    public static int rcp(int index, int rodLen,int price[],int dp[][]){
        
        
        if(index==0){
            return price[0]*rodLen;
        }
        
        if(dp[index][rodLen] != -1)
            return dp[index][rodLen];
        
        int cut = 0;
        if(index+1<=rodLen)
            cut += price[index] + rcp(index, rodLen-(index+1), price,dp);
        int notCut = 0 + rcp(index-1, rodLen, price,dp);
        
        return dp[index][rodLen] = Math.max(cut,notCut);
        
        
        
        // Recursion ... 
        // if(index==0){
        //     return price[0]*rodLen;
        // }
        // int cut = 0;
        // if(index+1<=rodLen)
        //     cut += price[index] + rcp(index, rodLen-(index+1), price);
        // int notCut = 0 + rcp(index-1, rodLen, price);
        
        // return Math.max(cut,notCut);
    }
}