public class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        
        double lastY = 0;
        double y = 1;
        
        while (y - lastY != 0){
            lastY = y;
            y = (lastY + x / lastY) / 2;
        }
        
        return (int) y;
    }
}