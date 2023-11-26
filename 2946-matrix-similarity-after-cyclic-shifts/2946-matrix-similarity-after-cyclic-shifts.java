class Solution {
    public boolean areSimilar(int[][] arr, int k) {
        
        int m = arr.length;
        int n = arr[0].length;
        
        k = k%n;
        
        for(int i = 0 ; i < m ; i++){
            if(i%2 != 0){
                // odd rows
                for(int j = 0; j < n; j++){
                    int p = (j + k) % n;
                    if(arr[i][j] != arr[i][p]) return false;
                }
            }
            else{
                // even rows
                for(int j = 0; j < n; j++){
                    int p = ((j - k < 0)?(n + j - k):(j - k)) % n;
                    if(arr[i][j] != arr[i][p]) return false;
                }
            }
        }
        
        return true;
    }
}