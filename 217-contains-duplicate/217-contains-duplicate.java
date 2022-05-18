class Solution {
    public boolean containsDuplicate(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int k : hm.values()){
            if(k>1){
                return true;
            }
        }
        return false;
    }
}