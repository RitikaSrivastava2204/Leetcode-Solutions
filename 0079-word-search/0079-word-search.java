class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean result = false;
        outer: for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(board,i,j,word,visited)){
                    result = true;
                    break outer;
                }
            }
        }
        return result;
    }
    public boolean exist(char[][] board, int row, int column, String word, boolean[][] visited){
        if(word.length() > board.length * board[0].length){
            return false;
        }
        if(word.length()==0){
            return true;
        }
        if(row<0 || row>=board.length || column<0 || column>=board[0].length){
            return false;
        }
        int next_row = (column == board[0].length-1)? row+1 : row;
        int next_column = (column == board[0].length-1)? 0 : column+1;
        if(visited[row][column]==false && board[row][column] == word.charAt(0)){ //matched
            visited[row][column] = true;
            if(exist(board,row,column+1,word.substring(1),visited)){
                return true;
            }
            else if(exist(board,row,column-1,word.substring(1),visited)){
                return true;
            }
            else if(exist(board,row+1,column,word.substring(1),visited)){
                return true;
            }
            else if(exist(board,row-1,column,word.substring(1),visited)){
                return true;
            }
            visited[row][column] = false;
        }
        return false;
        
    }

}