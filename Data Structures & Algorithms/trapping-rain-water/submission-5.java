class Solution {
    public int trap(int[] height) {
        int waterStored = 0;
        int curMaxLeft = 0;
        int curMaxRight = 0;
        for (int l = 0, r = height.length-1; l < r;) {
            if (height[l] <= height[r]) {
                waterStored += Math.max(curMaxLeft - height[l], 0);
                curMaxLeft = Math.max(curMaxLeft, height[l]);
                l++;
            } else {
                waterStored += Math.max(curMaxRight - height[r], 0);
                curMaxRight = Math.max(curMaxRight, height[r]);
                r--;
            }
        }

        return waterStored;
    }
}
