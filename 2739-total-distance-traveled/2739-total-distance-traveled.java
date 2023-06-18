class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        
        return 10 * ( mainTank + 
                      Math.min( (mainTank-1)/4 , additionalTank )
                    );
    }
}