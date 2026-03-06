import java.util.*;

public class BFS {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int nodesExplored = 0;
    public void findPath(Grid grid) {

        int rows = grid.rows;
        int cols = grid.cols;

        boolean[][] visited = new boolean[rows][cols];
        int[][] parentX = new int[rows][cols];
        int[][] parentY = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{grid.startX, grid.startY});
        visited[grid.startX][grid.startY] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            nodesExplored++;
            int x = current[0];
            int y = current[1];

            if (x == grid.goalX && y == grid.goalY) {

                System.out.println("Goal reached using BFS!");
                System.out.println("BFS explored: " + nodesExplored + " nodes");
                printPath(grid, parentX, parentY);
                return;

            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {

                    if (!visited[nx][ny] && grid.grid[nx][ny] != '#') {

                        visited[nx][ny] = true;
                        parentX[nx][ny] = x;
                        parentY[nx][ny] = y;

                        queue.add(new int[]{nx, ny});

                    }

                }

            }

        }

        System.out.println("No path found.");
    }

    private void printPath(Grid grid, int[][] parentX, int[][] parentY) {

        int x = grid.goalX;
        int y = grid.goalY;

        while (!(x == grid.startX && y == grid.startY)) {

            int px = parentX[x][y];
            int py = parentY[x][y];

            if (grid.grid[x][y] != 'G') {
                grid.grid[x][y] = '*';
            }

            x = px;
            y = py;
        }

        System.out.println("Path:");
        grid.printGrid();
    }
}