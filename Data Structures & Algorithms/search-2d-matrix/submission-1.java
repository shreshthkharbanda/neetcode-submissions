class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        System.out.println(Arrays.toString(matrix[0]));
        int top = 0;
        int bottom = matrix.length-1;
        int row = -1;
        while (top <= bottom) {
            int middle = (top+bottom)/2;
            if (matrix[middle][0] <= target && matrix[middle][matrix[0].length-1] >= target) {
                row = middle;
                break;
            }
            if (matrix[middle][0] > target) {
                bottom = middle-1;
            } else {
                top = middle+1;
            }
        }

        if (row == -1) return false;

        int left = 0;
        int right = matrix[0].length-1;
        while (left <= right) {
            int middle = (left+right)/2;
            if (matrix[row][middle] == target) {
                return true;
            }

            if (matrix[row][middle] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
        }

        return false;
    }
}
