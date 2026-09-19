class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

    for (String word : strs) {
        int[] count = new int[26];
        for (char c : word.toCharArray())
            count[c - 'a']++;

        // Encode int[26] as a string key: "1#0#0#1#0#..."
        StringBuilder sb = new StringBuilder();
        for (int n : count) sb.append(n).append('#');
        String key = sb.toString();

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
    }

    return new ArrayList<>(map.values());
    }
}
