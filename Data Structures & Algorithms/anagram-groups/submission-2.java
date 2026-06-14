class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            final Map<Character, Integer> chars = new HashMap<>();
            for (char c : str.toCharArray()) {
                chars.put(c, chars.getOrDefault(c, 0)+1);
            }

            if (groups.containsKey(chars)) {
                groups.get(chars).add(str);
            } else {
                final List<String> list = new ArrayList<>();
                list.add(str);
                groups.put(chars, list);
            }
        }

        final List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> group : groups.entrySet()) {
            result.add(group.getValue());
        }

        return result;
    }
}
