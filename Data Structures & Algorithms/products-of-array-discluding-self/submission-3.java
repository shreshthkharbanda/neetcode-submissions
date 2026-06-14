class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productsFromLeft = new int[nums.length];
        productsFromLeft[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            productsFromLeft[i] = nums[i] * productsFromLeft[i-1];
        }
        System.out.println(Arrays.toString(productsFromLeft));

        int[] productsFromRight = new int[nums.length];
        productsFromRight[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            productsFromRight[i] = nums[i] * productsFromRight[i+1];
        }
        System.out.println(Arrays.toString(productsFromRight));

        int[] result = new int[nums.length];
        result[0] = productsFromRight[1];
        result[nums.length-1] = productsFromLeft[nums.length-2];
        for (int i = 1; i < result.length-1; i++) {
            // System.out.println(i + ", " + productsFromLeft[i-1] + ", " + productsFromRight[i+1] + ", " + (productsFromLeft[i-1] * productsFromRight[i+1]));
            result[i] = productsFromLeft[i-1] * productsFromRight[i+1];
        }

        return result;
    }
}  
