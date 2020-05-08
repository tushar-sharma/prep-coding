public class WordSearch {

    public static boolean dfs(char[][] board, String word, boolean[][] visited, int start_i, int start_j, int index) {

        if(index == word.length())
            return true;

	    if(start_i < 0 || start_j < 0 || start_i >= board.length || start_j >= board[0].length || visited[start_i][start_j] || board[start_i][start_j]!=word.charAt(index)) {
            return false;
        }

        visited[start_i][start_j] = true;

        boolean res = dfs(board, word, visited, start_i, start_j + 1, index + 1) ||
                      dfs(board, word, visited, start_i, start_j - 1, index + 1) ||
                      dfs(board, word, visited, start_i + 1, start_j, index + 1) ||
                      dfs(board, word, visited, start_i - 1, start_j, index +1);

        visited[start_i][start_j] = false;

        return res;

    }


    public static boolean exist(char[][] board, String word) {

        if (word.isEmpty()) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                 }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] board = {
                          {'A', 'B', 'C', 'E'},
                          {'S', 'F', 'C', 'S'},
                          {'A', 'D', 'E', 'E'}
                          };

        assert exist(board, "ABCCED") == true;

        assert exist(board, "ABCB") == false;
    }
}
