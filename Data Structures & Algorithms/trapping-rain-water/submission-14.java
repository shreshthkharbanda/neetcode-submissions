class Solution {
    public int trap(int[] height) {
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
