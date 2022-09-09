class Solution {
    public int jump(int[] nums) {
        int jumps = 0 ;
        int l=0,r=0;
        
        while(r<nums.length-1){
            int furthest = 0;
            for(int i = l ; i <=r ;i++){
                furthest = Math.max(furthest,i+nums[i]);
            }
            l = r+1;
            r = furthest;
            jumps++;
        }
        
        return jumps;
    }
}