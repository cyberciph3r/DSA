//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Pair> s = new Stack<>();
        int arr[] = new int[n];
        int k = 0 ;
        for(int e : price){
            int days = 1;
            while(!s.isEmpty()&& s.peek().a<=e ){
                days+=s.peek().b;
                s.pop();
            }
            s.push(new Pair(e,days));
            arr[k++] = days;
        }
        
        return arr;
    }
    static class Pair{
        int a ,b;
        Pair(int first, int b){
            this.a = a;
            this.b = b;
        }
    }
    
}