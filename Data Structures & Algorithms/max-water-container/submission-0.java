class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        for (int start = 0, end = heights.length-1; start < end;) {
            int area = Math.min(heights[start], heights[end]) * (end-start);
            maxArea = Math.max(area, maxArea);

            if (heights[start] == heights[end]) {
                // int nextHighestStart = start+1;
                // while (nextHighestStart < heights.length && heights[start] == heights[nextHighestStart]) {
                //     nextHighestStart++;
                // }

                // int nextHighestEnd = end-1;
                // while (nextHighestEnd > 0 && heights[end] == heights[nextHighestEnd]) {
                //     nextHighestEnd--;
                // }

                // if (nextHighestStart > heights.length || nextHighestEnd < 0) return maxArea;
                // if (heights[nextHighestStart] > heights[nextHighestEnd]) {
                //     start = nextHighestStart;
                // } else {
                //     end = nextHighestEnd;
                // }
                start++;
            } else if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }

        return maxArea;
    }
}
