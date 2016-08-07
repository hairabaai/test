public class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1)
            return x;
            
        int start = 0;
        int end = x;
        int mid = 0;
        
        while (start<=end) {
            mid = start + (end - start) / 2;
            if (mid < x / mid) {
                if (mid+1 > x / (mid+1))
                    return mid;
            start = mid + 1;
            } else if (mid > x / mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
        
    }
}