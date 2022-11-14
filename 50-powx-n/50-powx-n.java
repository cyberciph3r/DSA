class Solution {
    public double myPow(double x, int n) {
        
        if(n==0)
            return 1;
        
        double ans = 1;
            
        ans = myPow(x,Math.abs(n/2));
        ans = ans*ans;
        
        if(n%2!=0)
            ans = ans*x;
        
        if(n<0)
            return 1/ans;
        
        return ans;
        
    }
}