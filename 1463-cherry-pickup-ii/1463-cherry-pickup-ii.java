class Solution {
    public int cherryPickup(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        // Memoization ...
        
        // int dp[][][] = new int[m][n][n];
        // for(int[][] row : dp){
        //     for(int[] col : row){
        //         Arrays.fill(col,-1);
        //     }
        // }
        // return ch2(0,0,n-1,m,n,arr,dp);
        
        
        
        
        
        
        // Tabulation ...
        
//         int dp[][][] = new int[m][n][n];
        
//         for(int j1 = 0 ; j1 < n ; j1++){
//             for(int j2=0 ; j2< n ; j2++){
//                 if(j1==j2)
//                     dp[m-1][j1][j2] = arr[m-1][j1];
//                 else
//                     dp[m-1][j1][j2] = arr[m-1][j1]+arr[m-1][j2];
//             }
//         }
        
//         for(int i = m-2 ; i>=0 ; i--){
//             for(int j1 = 0 ; j1< n ; j1++){
//                 for(int j2 = 0 ; j2 < n ; j2++){
                    
                    
//                     int maxi = -100000;
//                     for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
//                         for(int dj2 = -1 ; dj2<=+1 ; dj2++){
//                             int value = 0;
//                             if(j1==j2){
//                                 value = arr[i][j1];
//                             }else{
//                                 value = arr[i][j1]+arr[i][j2];
//                             }
//                             if(j1+dj1>=0 && j1+dj1<=n-1 && j2+dj2>=0 && j2+dj2<=n-1)
//                                 value += dp[i+1][j1+dj1][j2+dj2];
//                             else
//                                 value = -1000000;
//                             maxi = Math.max(maxi,value);
//                         }
//                     }

//                     dp[i][j1][j2] = maxi;
                    
//                 }
//             }
//         }
        
//         return dp[0][0][n-1];
        
        
        
        // Tabulation ... Space Optimized....
        
        int next[][] = new int[n][n];
        int cur[][] = new int[n][n];
        
        for(int j1 = 0 ; j1 < n ; j1++){
            for(int j2=0 ; j2< n ; j2++){
                if(j1==j2)
                    next[j1][j2] = arr[m-1][j1];
                else
                    next[j1][j2] = arr[m-1][j1]+arr[m-1][j2];
            }
        }
        
        for(int i = m-2 ; i>=0 ; i--){
            for(int j1 = 0 ; j1< n ; j1++){
                for(int j2 = 0 ; j2 < n ; j2++){
                    
                    
                    int maxi = -100000;
                    for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
                        for(int dj2 = -1 ; dj2<=+1 ; dj2++){
                            int value = 0;
                            if(j1==j2){
                                value = arr[i][j1];
                            }else{
                                value = arr[i][j1]+arr[i][j2];
                            }
                            if(j1+dj1>=0 && j1+dj1<=n-1 && j2+dj2>=0 && j2+dj2<=n-1)
                                value += next[j1+dj1][j2+dj2];
                            else
                                value = -1000000;
                            maxi = Math.max(maxi,value);
                        }
                    }

                    cur[j1][j2] = maxi;
                    
                }
                
            }
            for(int l = 0 ; l < cur.length ; l++){
                for(int v = 0 ; v < cur[0].length ; v++){
                    next[l][v] = cur[l][v];
                }
            }
        }
        
        return next[0][n-1];
      
    }
    public static int ch2(int i , int j1 , int j2 ,int m ,int n, int arr[][], int dp[][][]){
        
        
        if(j1<0||j1>=n||j2<0||j2>=n)
            return -1000000;
        if(i==m-1){
            if(j1==j2)
                return arr[m-1][j1];
            else 
                return arr[m-1][j1]+arr[m-1][j2];
        }
        
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        
        int maxi = -100000;
        for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
            for(int dj2 = -1 ; dj2<=+1 ; dj2++){
                int value = 0;
                if(j1==j2){
                    value = arr[i][j1];
                }else{
                    value = arr[i][j1]+arr[i][j2];
                }
                value += ch2(i+1,j1+dj1,j2+dj2,m,n,arr,dp);
                maxi = Math.max(maxi,value);
            }
        }
        
        return dp[i][j1][j2] = maxi;
        
        
        
        
        
        // Recursion ....
        
//         if(j1<0||j1>=n||j2<0||j2>=n)
//             return -1000000;
//         if(i==m-1){
//             if(j1==j2)
//                 return arr[m-1][j1];
//             else 
//                 return arr[m-1][j1]+arr[m-1][j2];
//         }
//         int maxi = -100000;
//         for(int dj1 = -1 ; dj1 <= +1 ; dj1++){
//             for(int dj2 = -1 ; dj2<=+1 ; dj2++){
//                 int value = 0;
//                 if(j1==j2){
//                     value = arr[i][j1];
//                 }else{
//                     value += arr[i][j1]+arr[i][j2];
//                 }
//                 value += ch2(i+1,j1+dj1,j2+dj2,m,n,arr);
//                 maxi = Math.max(maxi,value);
//             }
//         }
        
//         return maxi;
    }
}