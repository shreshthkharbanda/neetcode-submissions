class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left <= right) {
            if (nums[left] <= nums[right]) break;
            int middle = (left+right)/2;
            // in right spot, must be to left
            if (nums[middle] >= nums[left]) {
                left = middle+1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }
}
