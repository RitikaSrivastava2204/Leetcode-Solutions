class Solution {
    public void rotate(int[][] matrix) {
        int[][] copymatrix = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                copymatrix[i][j] = matrix[matrix.length-1-j][i];
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = copymatrix[i][j];
            }
        }

    }
}