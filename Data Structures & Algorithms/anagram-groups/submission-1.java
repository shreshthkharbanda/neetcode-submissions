class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] cs = str.toCharArray();
            Map<Character, Integer> tree = new TreeMap<>();
            for (char c : cs) {
                tree.put(c, tree.getOrDefault(c, 0)+1);
            }
            if (map.containsKey(tree)) {
                map.get(tree).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(tree, indices);
            }
        }

        List<List<String>> result = new ArrayList<List<String>>();
        for (Map.Entry<Map<Character, Integer>, List<Integer>> e : map.entrySet()) {
            List<Integer> indices = e.getValue();
            List<String> anagrams = new ArrayList<>();
            for (int ix : indices) {
                anagrams.add(strs[ix]);
            }
            result.add(anagrams);
        }

        return result;
    }
}
