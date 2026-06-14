class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) numbers.add(num);
        Collections.sort(numbers);

        System.out.println(numbers);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            int j = i+1, k = numbers.size()-1;
            while (j < numbers.size() && k >= 0 && j < k) {
                int n1 = numbers.get(i), n2 = numbers.get(j), n3 = numbers.get(k);
                if (n1 + n2 + n3 == 0) {
                    List<Integer> list = new ArrayList<>(List.of(n1, n2, n3));
                    if (!res.contains(list)) res.add(list);
                    j++;
                    k--;
                } else if (n1 + n2 + n3 > 0) {
                    k--;
                } else if (n1 + n2 + n3 < 0) {
                    j++;
                } 
            }
        }
        return res;
    }
}
