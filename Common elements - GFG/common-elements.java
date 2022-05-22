// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i=0,j=0,k=0;
        int last = Integer.MIN_VALUE;
        
        while(i<n1 && j<n2 && k < n3){
            if(A[i]==B[j] && A[i]==C[k] && A[i]!=last){
                res.add(A[i]);
                last=A[i];
                i++;j++;k++;
            }
            else if(Math.min(A[i],Math.min(B[j],C[k]))==A[i]){
                i++;
            }
            else if(Math.min(A[i],Math.min(B[j],C[k]))==B[j]){
                j++;
            }else
                k++;
        }
        
        
        return res;
    }
}