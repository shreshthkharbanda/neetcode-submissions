class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        System.out.println(map);

        for (char c : t.toCharArray()) {
            System.out.println(c + ", " + map);
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            map.put(c, map.get(c)-1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() != 0) return false;
        }

        return true;
    }
}
