/**

[1, 2, 4, 6]

at 1 = suf (2 * 4 * 6) = 48
at 2 = pre (1) * suf (4 * 6) = 24
at 4 = pre (1 * 2) * suf (6) = 12
at 6 = pre (1 * 2 * 4) = 8

*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];

        // no pre/suf at corners
        pre[0] = 1;
        suf[suf.length-1] = 1;

        // initial value - number
        pre[1] = nums[0];
        suf[suf.length-2] = nums[nums.length-1];

        for (int i = 2; i < nums.length; i++) {
            pre[i] = pre[i-1] * nums[i-1];
            suf[nums.length-i-1] = suf[nums.length-i] * nums[nums.length-i];
        }
        
        int[] res = new int[nums.length];
        res[0] = suf[0];
        res[res.length-1] = pre[res.length-1];

        for (int i = 0; i < res.length; i++) {
            res[i] = pre[i] * suf[i];
        }

        return res;
    }
}  
