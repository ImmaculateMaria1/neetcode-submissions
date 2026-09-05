class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Check adjacent elements
        for(int i = 0; i < nums.length - 1; i++) {
            // If current element equals next element
            if(nums[i] == nums[i + 1]) {
                return true;  // Found duplicate!
            }
        }
        
        return false;  // No duplicates found
    }
}