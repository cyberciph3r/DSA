//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends

class Solution{
    static int countMin(String str)
    {
        String s1 = str;
        String s2 = "";
        int n1 = s1.length();
        for(int i = n1-1 ; i>=0 ; i--){
            s2+=s1.charAt(i);
        }
        int n2 = s2.length();
        
        //Memoization ... (Top-Down)....
        int dp[][] = new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        
        return n1-lcs(n1-1,n2-1,s1,s2,dp);
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