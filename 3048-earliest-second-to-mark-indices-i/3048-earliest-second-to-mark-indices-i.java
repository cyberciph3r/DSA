class Solution {
    public int earliestSecondToMarkIndices(int[] arr, int[] changeIndices) {
        
        int m = changeIndices.length;
        
        // We can apply BS also for the below linear traversal...
        for(int i = 1 ; i <= m ; i++){
            if(isPossible(i,changeIndices,arr)){
                return i;
            }
        }
        
        return -1;
    }
    public boolean isPossible(int n, int changeIndices[], int arr[]){
        
        HashMap<Integer,Integer> lastInds = new HashMap<>();
        
        for(int i = n-1 ; i >= 0 ; i--){
            if(!lastInds.containsKey(changeIndices[i])){
                lastInds.put(changeIndices[i],i);
            }
        }
        
        for(int i = 1 ; i <= arr.length ; i++){
            if(!lastInds.containsKey(i)){
                return false;
            }
        }
        
        ArrayList<Pair> eleToLastInd = new ArrayList<>();
        
        for(int k : lastInds.keySet()){
            eleToLastInd.add(new Pair(k,lastInds.get(k)));
        }
        
        Collections.sort(eleToLastInd,(a,b)->{
            return a.lastInd-b.lastInd;
        });
        
        int cnt = 0;
        for(Pair p : eleToLastInd){
            
            int x = p.ele;
            int xLastInd = p.lastInd;
            
            int req = arr[x-1]+1;
            
            if(cnt+req > xLastInd+1){
                
                // why +1 ? -> let [1,1,1,1] be the changeIndices[], 
                // lastIndex of 1 is 3. But there are 4 1s.
                // so if req = 4, and lastInd = 3, it means, there are 4 
                // chances. +1 is to make 0 indexed to 1 indexed, or 
                // changing 0 index counting to 1 indexed counting.
                // Dry run arr=[3], changedInds = [1,1,1,1] for better understanding.
                
                return false;
            }
            
            cnt += req;
        }
        
        return true;
    }
    class Pair{
        int ele, lastInd;
        Pair(int ele, int lastInd){
            this.ele = ele;
            this.lastInd = lastInd;
        }
    }
}