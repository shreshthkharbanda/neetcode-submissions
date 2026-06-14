class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        int maxLeft = height[0], maxRight = height[height.length-1];
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(height[i], maxLeft);
            maxRight = Math.max(height[height.length-1-i], maxRight);
            left[i] = maxLeft;
            right[height.length-1-i] = maxRight;
        }

        int area = 0;
        for (int i = 0; i < height.length; i++) {
            area += Math.min(left[i], right[i]) - height[i];
        }

        return area;
    }
}
