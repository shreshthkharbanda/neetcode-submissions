class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int start = 0, end = heights.length-1; start < end;) {
            int area = Math.min(heights[start], heights[end]) * (end-start);
            maxArea = Math.max(area, maxArea);

            if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }

        return maxArea;
    }
}
