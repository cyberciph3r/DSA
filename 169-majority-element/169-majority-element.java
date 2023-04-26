class Solution {
    public int majorityElement(int[] arr) {
        
        int n = arr.length;
        int ans = arr[0];
        int cnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i] == ans){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    ans = arr[i];
                    cnt++;
                }
            }
        }
        
        return ans;
    }
}