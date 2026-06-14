class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int start = 0, end = numbers.length-1; start < end;) {
            int curSum = numbers[start] + numbers[end];
            if (curSum == target) {
                return new int[]{start+1, end+1};
            }

            if (curSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{-1, -1};
    }
}
