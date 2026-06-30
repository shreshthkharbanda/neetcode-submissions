class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right && left >= 0 && right <= nums.length-1 && Math.abs(left-right) != 1) {
            int mid = (left + right) / 2;
            System.out.println(left + ", " + right + ", " + mid + " ; " + nums[mid]);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid;
            else if (nums[mid] < target) left = mid;
        }

        return nums[left] == target ? left : nums[right] == target ? right : -1;
    }
}
