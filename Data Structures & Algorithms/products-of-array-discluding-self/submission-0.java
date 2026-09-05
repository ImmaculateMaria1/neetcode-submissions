class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,1);
        int prefix = 1, post = 1;

        for(int i=0;i<nums.length;i++){
            result[i] = prefix;
            prefix = nums[i] * prefix;
        }

        for(int i=nums.length-1;i>=0;i--){
            result[i] = result[i] * post;
            post = nums[i] * post;
        }

        return result;
    }
}  
