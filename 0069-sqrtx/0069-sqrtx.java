class Solution {
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        long mid;
        long ans;

        while(low<=high)
        {
            mid = low + (high-low)/2 ;
            ans = mid*mid;
            if(ans <= x)
            {
                low = (int)mid+1;
            }
            else
            {
                high = (int)mid -1;
            }
            
        }
        return high;
        
    }
}