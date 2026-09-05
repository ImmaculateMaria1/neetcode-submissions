class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create pairs of [value, original_index]
        int[][] pairs = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Sort by value
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        // Two pointers
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            
            if(sum == target) {
                int idx1 = pairs[left][1];
                int idx2 = pairs[right][1];
                
                // Return indices in ascending order
                return new int[] {Math.min(idx1, idx2), Math.max(idx1, idx2)};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[] {};
    }
}