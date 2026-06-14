class Solution {
    public int trap(int[] height) {
        // int start = 0;
        // int end = height.length-1;
        int waterStored = 0;

        // int maxLeft[] = new int[height.length];
        // int maxRight[] = new int[height.length];

        int curMaxLeft = 0;
        int curMaxRight = 0;
        // for (int i = 0; i < height.length; i++) {
        //     curMaxLeft = Math.max(curMaxLeft, height[i]);
        //     maxLeft[i] = curMaxLeft;

        //     curMaxRight = Math.max(curMaxRight, height[height.length - i - 1]);
        //     maxRight[height.length - i - 1] = curMaxRight;
        // }

        // l = 0, 4; r = 0, 4; 
        for (int l = 0, r = height.length-1; l < r;) {
            if (height[l] <= height[r]) {
                waterStored += Math.max(curMaxLeft - height[l], 0);
                curMaxLeft = Math.max(curMaxLeft, height[l]);
                l++;
            } else {
                System.out.println("before2: " + l + ", " + r);
                waterStored += Math.max(curMaxRight - height[r], 0);
                curMaxRight = Math.max(curMaxRight, height[r]);
                r--;
                System.out.println("after2: " + l + ", " + r);
            }
            // waterStored += Math.max((Math.min(height[l], height[r]) - height[i]), 0);
        }

        return waterStored;
    }
}
