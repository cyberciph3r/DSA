class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        //Tabulation....
        
        int cur[] = new int[n+1];
        int next[] = new int[n+1];
        
        for(int index = n-1; index >=0 ; index--){
            for(int prev_ind = index-1 ; prev_ind >= -1 ; prev_ind--){
                int take = 0;
                if(prev_ind==-1 || nums[index]>nums[prev_ind]){
                    take = 1 + next[index+1];
                }
                int notTake = next[prev_ind+1];

                cur[prev_ind+1] = Math.max(take,notTake);
            }
            next = cur.clone();
        }
        
        return next[-1+1];
        
        //Tabulation....
        
//         int dp[][] = new int[n+1][n+1];
        
//         for(int index = n-1; index >=0 ; index--){
//             for(int prev_ind = index-1 ; prev_ind >= -1 ; prev_ind--){
//                 int take = 0;
//                 if(prev_ind==-1 || nums[index]>nums[prev_ind]){
//                     take = 1 + dp[index+1][index+1];
//                 }
//                 int notTake = dp[index+1][prev_ind+1];

//                 dp[index][prev_ind+1] = Math.max(take,notTake);
//             }
//         }
        
//         return dp[0][-1+1];
        
        
        
        //Memoization....
        
//         int dp[][] = new int[n][n+1];
        
//         for(int[] row:dp){
//             Arrays.fill(row,-1);
//         }
        
//         return lis(0,-1,nums,dp);
    }
    public static int lis(int index, int prev_ind,int nums[],int dp[][]){
        
        if(index==nums.length)
            return 0;
        
        if(dp[index][prev_ind+1] != -1)
            return dp[index][prev_ind+1];
        
        int take = 0;
        if(prev_ind==-1 || nums[index]>nums[prev_ind]){
            take = 1 + lis(index+1,index,nums,dp);
        }
        int notTake = lis(index+1,prev_ind,nums,dp);
        
        return dp[index][prev_ind+1] = Math.max(take,notTake);
        
        
        
        
        // Recursion...
        
//         if(index==nums.length)
//             return 0;
        
//         int take = 0;
//         if(prev_ind==-1 || nums[index]>nums[prev_ind]){
//             take = 1 + lis(index+1,index,nums);
//         }
//         int notTake = lis(index+1,prev_ind,nums);
        
//         return Math.max(take,notTake);
    }
}