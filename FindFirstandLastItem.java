class FindFirstandLastItem {
  
    /*
        Time : O(lg(N) + lg(N)) ~ O(lg(N))
        Space : O(1)
    */
  
   // Approach
   /*
      When we find first element, go towards left with binary search and find starting position of target.
      Apply same logic while finding right position of target.
      [1, 2, 4, 3, 3, 5, 6, 7, 7, 7, 7, 9, 10, 10] | target = 10
       L                    m                   H
       find first is called
       L                    m                   H
                               L     m          H | 8+13/2 = 10
                                       L    m   H | 11+13/ 2 = 12 | nums[12] == target hence check left element : ([mid-1] != target) return mid = 10 
                                       
   */
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[]{};
        
        int first = binarySearchFirst(nums, target);
        int last = -1;
        if(first != -1){
            last = binarySearchLast(nums, target);
        }
        return new int[] {first,last};
    }
    
    int binarySearchLast(int[] nums, int target){
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                // edge case, mid might go out of bounds,
                if(mid == n - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid -1;
            }
            
        }
        
        return -1;
    }
    
    int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                // edge case, mid might go out of bounds,    
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
