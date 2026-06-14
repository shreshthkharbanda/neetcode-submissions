class Solution {
    public int trap(int[] height) {
        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];
        maxL[0] = height[0];
        maxR[maxR.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(maxL[i-1], height[i]);
            maxR[height.length-i-1] = Math.max(maxR[height.length-i], height[height.length-i-1]);
        }

        System.out.println(Arrays.toString(maxL));
        System.out.println(Arrays.toString(maxR));

        int area = 0;
        for (int i = 1; i < height.length-1; i++) {
            int minB = Math.min(maxL[i], maxR[i]);
            int water = Math.max(minB - height[i], 0);
            area += water;
        }

        return area;
    }
}
