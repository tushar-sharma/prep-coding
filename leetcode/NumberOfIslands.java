/**
 * leetcode: https://leetcode.com/problems/number-of-islands/
 */
import java.util.Arrays;

public class NumberOfIslands{

    public static int dfs(char[][] grid, int i , int j, boolean[][] visited) {

        visited[i][j] = true;

        if ( (i + 1) < grid.length && grid[i + 1][j]  == '1' && visited[i + 1][j] == false) {
            dfs(grid, i + 1, j , visited);
        }

        if ( (i - 1) >= 0 && grid[i - 1][j]  == '1' && visited[i - 1][j] == false) {
            dfs(grid, i - 1, j , visited);
        }


        if ( (j + 1) < grid[0].length && grid[i][j + 1]  == '1' && visited[i][j + 1] == false) {
            dfs(grid, i, j + 1 , visited);

        }

        if ( (j - 1) >= 0 && grid[i][j - 1]  == '1' && visited[i][j - 1] == false) {
            dfs(grid, i, j - 1 , visited);

        }

        return 1;
    }

    public static int numIslands(char[][] grid) {
        int count = 0;

        if (grid.length < 0) {
            return count;
        }

        int length = grid.length;
        int breadth = grid[0].length;

        boolean[][] visited = new boolean[length][breadth];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (visited[i][j] == false && grid[i][j] == '1') {
                    count += dfs(grid, i, j, visited);
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {

        char[][] grid1 = new char[][]{
                                      {'1', '1', '1', '1', '0'},
                                      {'1', '1', '0', '1', '0'},
                                      {'1', '1', '0', '0', '0'},
                                      {'0', '0', '0', '0', '0'}
                                  };

        char[][] grid2 = new char[][]{
                                      {'1', '1', '0', '0', '0'},
                                      {'1', '1', '0', '0', '0'},
                                      {'0', '0', '1', '0', '0'},
                                      {'0', '0', '0', '1', '1'}
                                  };

        char[][] grid3 = new char[][]{
                                      {'1', '1', '1'},
                                      {'0', '1', '0'},
                                      {'1', '1', '1'}
                                  };


        assert numIslands(grid1) == 1;

        assert numIslands(grid2) == 3;

        assert numIslands(grid3) == 1;
    }
}
