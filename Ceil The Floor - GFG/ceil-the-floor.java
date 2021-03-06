// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}
// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {

        int flDiff=Integer.MAX_VALUE;
        int clDiff = Integer.MAX_VALUE;
        int flInd = 0;
        int clInd= 0;
        
        for(int i = 0 ; i < n ; i++){
            if(x<=arr[i] && clDiff>(arr[i]-x)){
                clInd=i;
                clDiff = arr[i]-x;
            }
            if(x>=arr[i] && flDiff>(x-arr[i])){
                flInd = i;
                flDiff = x-arr[i];
            }
        }
        
        Pair pp = new Pair(-1,-1);
        if(clDiff!=Integer.MAX_VALUE){
            pp.ceil  = arr[clInd];
        }
        if(flDiff!=Integer.MAX_VALUE){
            pp.floor = arr[flInd];
        }
        
        return pp;
        
        
        
        
        // Arrays.sort(arr);
        // int flr = -1;
        // int cl = -1;
        // for(int i = 0 ; i < n ; i++){
        //     if(x<=arr[i]){
        //         cl = arr[i];
        //         break;
        //     }
        // }
        // for(int i = n-1 ; i >=0 ; i--){
        //     if(arr[i]<=x){
        //         flr = arr[i];
        //         break;
        //     }
        // }
        // return new Pair(flr,cl);
    }
}

