class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n,count.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] bucketList = new List[nums.length+1];

        for(int i=0;i<=nums.length;i++){
            bucketList[i] = new ArrayList<>();
        }

        for(int num : count.keySet()){
            int freq = count.get(num);
            bucketList[freq].add(num);
        }

        int[] result = new int[k];

        int index = 0;

        for(int freq = bucketList.length-1;freq >=0 && index<k; freq--){
            for(int num1 : bucketList[freq]){
                result[index++] = num1;
                if(index == k) return result;
            }
        }
        return result;
    }
}
