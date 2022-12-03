class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            int curSum = 0;
            for(int j = i ; j < arr.length ; j++){
                curSum +=arr[j];
                if((j-i+1)%2!=0){
                    sum+=curSum;
                }
            }
        }
        
        return sum;
    }
}