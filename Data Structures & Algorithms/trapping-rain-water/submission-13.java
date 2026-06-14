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
        int maxL = height[0], maxR = height[height.length-1];
        for (int l = 0, r = height.length-1; l < r;) {
            if (maxL < maxR) {
                area += Math.max(0, maxL - height[l]);
                l++;
                maxL = Math.max(height[l], maxL);
            } else {
                area += Math.max(0, maxR - height[r]);
                r--;
                maxR = Math.max(height[r], maxR);
            }
        }

        return area;
    }
}
