//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // this Q can also be solved using dijkstra algo. if no -ve cycles. TC -> V*E*logV..
        
        // TC -> O(N*N*N)... 
        
        int n = matrix.length;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)1e7;
                }
            }
        }
        
        // Floyd Warshall Algo...
        
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        // To detect -ve cycle...not asked in Q..
        
        // for(int i = 0 ; i < n ; i++){
        //     if(matrix[i][i] < 0){
        //         return "-ve Cycle exists..."
        //     }
        // }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == (int)1e7){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}