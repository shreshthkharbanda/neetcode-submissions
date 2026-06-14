class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        System.out.println(Arrays.toString(matrix[0]));
        int top = 0;
        int bottom = matrix.length-1;

        int row = -1;
        int i = 0;
        while (top <= bottom && i < 5) {
            int middle = (top+bottom)/2;
            System.out.println(top + ", " + bottom + ", " + middle + " -- " + matrix[middle][0] + ", " + matrix[middle][matrix[0].length-1]);
            if (matrix[middle][0] <= target && matrix[middle][matrix[0].length-1] >= target) {
                row = middle;
                break;
            }
            if (matrix[middle][0] > target) {
                bottom = middle-1;
            } else {
                top = middle+1;
            }
            i++;
        }  

        System.out.println(row);

        if (row == -1) return false;

        int left = 0;
        int right = matrix[0].length-1;
        i = 0;
        while (left <= right && i < 10) {
            int middle = (left+right)/2;
            System.out.println(left + ", " + right + ", " + middle + " -- " + matrix[row][middle]);
            if (matrix[row][middle] == target) {
                return true;
            }

            if (matrix[row][middle] > target) {
                right = middle-1;
            } else {
                left = middle+1;
            }
            i++;
        }

        return false;
    }
}
