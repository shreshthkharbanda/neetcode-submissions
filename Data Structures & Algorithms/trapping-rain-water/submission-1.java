class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = start+1;
        int waterStored = 0;

        int maxLeft[] = new int[height.length];
        int maxRight[] = new int[height.length];

        int curMaxLeft = 0;
        int curMaxRight = 0;
        for (int i = 0; i < height.length; i++) {
            curMaxLeft = Math.max(curMaxLeft, height[i]);
            maxLeft[i] = curMaxLeft;

            curMaxRight = Math.max(curMaxRight, height[height.length - i - 1]);
            maxRight[height.length - i - 1] = curMaxRight;
        }

        for (int i = 0; i < height.length; i++) {
            waterStored += Math.max((Math.min(maxLeft[i], maxRight[i]) - height[i]), 0);
        }

        return waterStored;
    }
}
