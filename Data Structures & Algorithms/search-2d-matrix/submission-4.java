class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] combined = new int[matrix.length * matrix[0].length];
        int top = 0;
        int bottom = matrix.length-1;
        int mid = (top + bottom) / 2;
        while (top <= bottom) {
            mid = (top + bottom) / 2;
            if (matrix[mid][matrix[mid].length-1] < target) top = mid+1;
            else if (matrix[mid][0] > target) bottom = mid-1;
            else if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target) break;
        }

        System.out.println();
        System.out.println();

        int left = 0;
        int right = matrix[mid].length-1;
        int cell = (left + right) / 2;
        while (left <= right) {
            cell = (left + right) / 2;
            if (matrix[mid][cell] == target) return true;
            else if (matrix[mid][cell] > target) right = cell-1;
            else if (matrix[mid][cell] < target) left = cell+1;
        }

        return false;
    }
}
