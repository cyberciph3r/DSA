class Solution {
    public int minimumDeletions(String word, int k) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char ch : word.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        int n = hm.size();
        int arr[] = new int[n];
        int index = 0;
        for(char ch : hm.keySet()){
            arr[index++] = hm.get(ch);
        }
        
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for(int l = 0 ; l <= (int)1e5 ; l++){
            int r = Math.min(l+k,(int)1e5);
            int cur = 0;
            for(int i = 0 ; i < n ; i++){
                if(arr[i] < l){
                    cur += arr[i];
                }else if(arr[i] > r){
                    cur += arr[i]-r;
                }
            }
            
            res = Math.min(res,cur);
        }
        
        return res;
    }
}