//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String s1, String s2){
	    
	    int n1 = s1.length();
	    int n2 = s2.length();
	    
	    
        // Tabulation ... (Buttom-Up) ...Space Optimized....
        
        int prev[] = new int[n2+1];
        int cur[] = new int[n2+1];
        
        for(int index1 = 1 ; index1 <= n1; index1++){
            for(int index2 = 1 ; index2 <= n2 ; index2++){
                if(s1.charAt(index1-1)==s2.charAt(index2-1)){
                    cur[index2] = 1+prev[index2-1];
                }
                else 
                    cur[index2] = Math.max(prev[index2],cur[index2-1]);
            }
            prev = cur.clone();
        }
        
        
        int common = cur[n2];
        
        int deletions = n2-common;
        int insertions = n1 - common;
        
        return insertions+deletions;
        
        
        
        
        // Tabulation ... (Buttom-Up) ...
        
        // int dp[][] = new int[n1+1][n2+1];
        
        // for(int index1 = 1 ; index1 <= n1; index1++){
        //     for(int index2 = 1 ; index2 <= n2 ; index2++){
        //         if(s1.charAt(index1-1)==s2.charAt(index2-1)){
        //             dp[index1][index2] = 1+dp[index1-1][index2-1];
        //         }
        //         else 
        //             dp[index1][index2] = Math.max(dp[index1-1][index2],dp[index1][index2-1]);
        //     }
        // }
    
        // int common = dp[n1][n2];
        // int deletions = n2-common;
        // int insertions = n1 - common;
        
        // return insertions+deletions;
        
        
        
        
        
        //Memoization ... (Top-Down)....
        
        // int dp[][] = new int[n1][n2];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);
        // }
        
        // int common = lcs(n1-1,n2-1,s1,s2,dp);
        // int deletions = n2-common;
        // int insertions = n1 - common;
        
        // return insertions+deletions;
        
    }
    static int lcs(int index1,int index2 , String s1, String s2,int dp[][]){
        if(index1<0||index2<0){
            return 0;
        }
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2] = 1+lcs(index1-1,index2-1,s1,s2,dp);
        }
        return dp[index1][index2] = Math.max(lcs(index1-1,index2,s1,s2,dp),lcs(index1,index2-1,s1,s2,dp));
    }
}