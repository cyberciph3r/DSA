class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int dp[][][] = new int[m][n+2][m+1];
        for(int a[][] : dp){
            for(int b[] : a){
                Arrays.fill(b,-1);
            }
        }
        
        int res = f(0,-1,0,houses,cost,target,dp);
        
        return res == (int)1e7 ? -1 : res;
    }
    public static int f(int index, int prevEle, int cnt,
                        int houses[], int cost[][], int target, int dp[][][]){
        
        if(cnt > target){
            return (int)1e7;
        }
        
        if(index == houses.length){
            if(cnt != target){
                return (int)1e7;
            }
            
            return 0;
        }
        
        if(dp[index][prevEle+1][cnt] != -1){
            return dp[index][prevEle+1][cnt];
        }
        
        int ans = (int)1e7;
        
        if(houses[index] != 0){
            int newCnt = 1;
            if(prevEle != -1){
                newCnt = prevEle == houses[index] ? cnt : cnt+1;
            }
            ans = f(index+1,houses[index],newCnt,houses,cost,target,dp);
        }else{
            
            for(int j = 0 ; j < cost[0].length ; j++){
                houses[index] = j+1;
                int newCnt = 1;
                if(prevEle != -1){
                    newCnt = prevEle == houses[index] ? cnt : cnt+1;
                }
                int cur = cost[index][j] + f(index+1,j+1,newCnt,houses,cost,target,dp);
                houses[index] = 0;
                ans = Math.min(ans,cur);
            }
        }
        
        return dp[index][prevEle+1][cnt] = ans;
    }
}