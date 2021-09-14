package DS1;

public class Search2D {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
        };
        for (int i = 0; i < 62; i++) {
            boolean res = searchMatrix(matrix, i);
            System.out.println(i + ": " + res);
        }
    }
    public static boolean searchMatrix(int[][] m, int target) {
        if (m[0][0] > target) {
            return false;
        }
        int cols = m[0].length;
        int rows = m.length;
        if (m[rows - 1][cols - 1] < target) {
            return false;
        }
        int i = 0;
        int j = rows - 1;
        int mid = 0;
        boolean rowFound = false;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (m[mid][0] == target || m[mid][cols - 1] == target) {
                return true;
            }
            if (m[mid][0] > target) {
                j = mid - 1;
            } else {
                if (m[mid][cols - 1] < target) {
                    i = mid + 1;
                } else {
                    rowFound = true;
                    break;
                }
            }
        }
        if (!rowFound) {
            return false;
        }
        i = 0; j = cols - 1;
        int row = mid;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (m[row][mid] == target) {
                return true;
            } else if (m[row][mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
