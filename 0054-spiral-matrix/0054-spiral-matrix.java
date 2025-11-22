class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        spiralOrder(matrix, 0, matrix.length-1, 0, matrix[0].length-1, result);
        return result;
    }
    public void spiralOrder(int[][] matrix, int startRow, int endRow, int startCol, int endCol, List<Integer> result){

        // base case
        if(result.size() == matrix.length * matrix[0].length) return;
        if(startRow>endRow || startCol>endCol) return;

        for(int j=startCol; j<=endCol; j++){
            result.add(matrix[startRow][j]);
        }
        if(result.size() == matrix.length * matrix[0].length) return;
        for(int i=startRow+1; i<endRow; i++){
            result.add(matrix[i][endCol]);
        }
        if(result.size() == matrix.length * matrix[0].length) return;
        int[] lastRow = reverseArr(matrix[endRow]);

        for(int j=startCol; j<=endCol; j++){
            result.add(lastRow[j]);
        }
        if(result.size() == matrix.length * matrix[0].length) return;
        for(int i=endRow-1; i>startRow; i--){
            result.add(matrix[i][startCol]);
        }
        spiralOrder(matrix, startRow+1, endRow-1, startCol+1, endCol-1, result);
    }
    public int[] reverseArr(int[] arr){
        int start = 0;
        int end = arr.length -1;
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}