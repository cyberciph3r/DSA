class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        
        int maxi = 1;
        
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int prev = 0 ; prev < i ; prev++){
                if(arr[i]>arr[prev] && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    cnt[i] = cnt[prev];
                }else if(arr[i]>arr[prev] && 1+dp[prev]==dp[i]){
                    cnt[i]+=cnt[prev];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        
        for(int e : cnt)
            System.out.print(e+" ");
        
        int nos = 0;
        for(int i = 0 ; i < n ; i++){
            if(dp[i]==maxi){
                nos+=cnt[i];
            }
        }
        
        return nos;
    }
}