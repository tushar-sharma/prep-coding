class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int left = 0, right = arr.length - 1; 
        
        /*
         * we find the index of element in the array if exist
         * or one position before that
         */
        int mid = 0, index = -1;
        
        while (left <= right) {
            mid = left + (right - left) / 2; 
            
            if (arr[mid] == x) {
                index = mid;
                break;
            } else if (arr[mid] > x) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
                
        List<Integer> outputClosestElement = new ArrayList<>();
        
        int rem = k; 
        
        /*
         * if x doesn't exist in the array
         */
        if (index == -1)  { 
            
            // if element is not in the array
            if (x < arr[0] || x > arr[arr.length - 1]) {
                left = -1;
            }
            left = right;
            right = left + 1;
        } else { //x exist in the array 
            //System.out.println("[debug] x exist in the array");
            outputClosestElement.add(arr[mid]);   
            left = mid - 1; 
            right= mid + 1; 
            rem--;
        }
        
        while (left >= 0 && right <= arr.length - 1 && rem > 0) {
            int left_value = x - arr[left];
            int right_value = arr[right] - x;
            
            if (left_value <= right_value) {
                //System.out.println(arr[left]);
                outputClosestElement.add(arr[left]);
                left--; 
                rem--;
            }
            
            else {
                outputClosestElement.add(arr[right]);
                right++; 
                rem--;
            }
        }  
        
        while (left >= 0 && rem > 0 ) {
            outputClosestElement.add(arr[left--]); 
            rem--;
        }
        
        while (right < arr.length && rem > 0 ) {
            outputClosestElement.add(arr[right++]);
            rem--;
        }
        
        Collections.sort(outputClosestElement);
        
        return outputClosestElement; 
    }
    
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 3}, 1, 2));
    }
}
