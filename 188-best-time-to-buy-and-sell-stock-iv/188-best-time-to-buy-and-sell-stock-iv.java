class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        // Refer to Best Time to Buy and Sell Stock 3 for another approach ... replace cap = k
        
        //Tabulation .. Space Optimized...
        int cur[] = new int[(2*k)+1];
        int next[] = new int[(2*k)+1];
        
        for(int index = n-1 ; index>=0 ; index--){
            for(int transaction = 2*k-1 ; transaction >=0 ; transaction--){
                if(transaction%2==0){
                    cur[transaction] = Math.max(
                                                        next[transaction+1]-prices[index],
                                                        next[transaction]-0     );
                }else{
                    cur[transaction] = Math.max(
                                                        next[transaction+1]+prices[index],
                                                        next[transaction]+0     );
                }
            }
            next = cur;
        }
        
        return next[0];
        
        
        
        //Tabulation .. 
//         int dp[][] = new int[n+1][(2*k)+1];
        
//         for(int index = n-1 ; index>=0 ; index--){
//             for(int transaction = 2*k-1 ; transaction >=0 ; transaction--){
//                 if(transaction%2==0){
//                     dp[index][transaction] = Math.max(
//                                                         dp[index+1][transaction+1]-prices[index],
//                                                         dp[index+1][transaction]-0     );
//                 }else{
//                     dp[index][transaction] = Math.max(
//                                                         dp[index+1][transaction+1]+prices[index],
//                                                         dp[index+1][transaction]+0     );
//                 }
//             }
//         }
        
//         return dp[0][0];
        
        
        // Memoization...
        
        // int dp[][] = new int[n][2*k];
        // for(int[] row: dp){
        //     Arrays.fill(row,-1);
        // }
        // return bss4(0,0,k,prices,dp);
    }
    public static int bss4(int index,int transaction,int k,int prices[],int dp[][]){
        
        if(index==prices.length||transaction==2*k)
            return 0;
        
        if(dp[index][transaction] != -1)
            return dp[index][transaction];
        
        if(transaction%2==0){
            return dp[index][transaction] = Math.max(
                                                bss4(index+1,transaction+1,k,prices,dp)-prices[index],
                                                bss4(index+1,transaction,k,prices,dp)-0     );
        }else{
            return dp[index][transaction] = Math.max(
                                                bss4(index+1,transaction+1,k,prices,dp)+prices[index],
                                                bss4(index+1,transaction,k,prices,dp)+0     );
        }
        
        
        
        // Recursion ...
        
//         if(index==prices.length||transaction==2*k)
//             return 0;
        
//         if(transaction%2==0){
//             return Math.max(bss4(index+1,transaction+1,k,prices)-prices[index],
//                                 bss4(index+1,transaction,k,prices)-0);
//         }else{
//             return Math.max(bss4(index+1,transaction+1,k,prices)+prices[index],
//                                 bss4(index+1,transaction,k,prices)+0);
//         }
    }
}