class Solution {
    public int search(int[] arr, int target) {
        
        int n = arr.length;
        
        int s = 0;
        int e = n-1;
        
        while(s<=e){
            
            int m = s+(e-s)/2;
            if(arr[m]==target){
                return m;
            }
            
            if(arr[s]<=arr[m]){
                if(arr[s]<=target && target<arr[m]){
                    e = m-1;
                }else{
                    s = m+1;    
                }
            }else{
                if(arr[m]<target && target<=arr[e]){
                    s = m+1;
                }else{
                    e = m-1;
                }
            }
        }
        
        return -1;
        
        
        
        
        
        // int pivot = findPivot(arr);
        // int ans = bs(arr,target,0,pivot);
        // if(ans != -1)
        //     return ans;
        // return bs(arr,target,pivot+1,arr.length-1);
        
    }
    public static int findPivot(int arr[]){
        
        if(arr.length==1)
            return 0;
        
        int s = 0;
        int e = arr.length-1;
        
        while(s<e){
            int m = s+(e-s)/2;
            
            if(arr[m]>arr[m+1]){
                return m;
            }
            
            if(arr[s]<=arr[m]){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        
        return s;
    }
    public static int bs(int arr[],int x , int s , int e){
        while(s<=e){
            int m = s+(e-s)/2;
            
            if(x==arr[m])
                return m;
            
            if(x<arr[m]){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        
        return -1;
    }
}