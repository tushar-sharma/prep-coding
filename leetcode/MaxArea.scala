object Solution {
    def whileLoop(left : Int, 
                  right : Int, 
                  height : Array[Int],
                  maxArea : Int) : Int = {
        
        if (left >= height.length) {
            return maxArea;
        }

        
        var tempArea : Int = (maxArea).max(height(left).min(height(right)) * (right - left)); 
        
        if (height(right) >= height(left)) {
            return whileLoop(left + 1, right, height, tempArea);
        } else {
            return whileLoop(left, right  - 1, height, tempArea);
        }
        
        if (left.compare(right)  == 0){
            return tempArea;
        } else {
            0
        }
        

        
    }
   
    def maxArea(height: Array[Int]): Int = {
        
        if (height.length < 2) {
            return 0;
        }
        
        var maxArea : Int = 0;
        var left: Int  = 0; 
        var right: Int = height.length - 1;
        
        return whileLoop(left, right, height, maxArea);
        
    }
}
