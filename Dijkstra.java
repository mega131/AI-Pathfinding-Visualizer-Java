import java.util.*;

public class Dijkstra {
    int nodesExplored = 0;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void findPath(Grid grid) {

        int rows = grid.rows;
        int cols = grid.cols;

        int[][] dist = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        int[][] parentX = new int[rows][cols];
        int[][] parentY = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        dist[grid.startX][grid.startY] = 0;
        pq.add(new int[]{grid.startX, grid.startY, 0});

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();
            nodesExplored++;
            int x = cur[0];
            int y = cur[1];

            if (visited[x][y]) continue;
            visited[x][y] = true;

            if (x == grid.goalX && y == grid.goalY) {
                System.out.println("Goal reached using Dijkstra!");
                System.out.println("Dijkstra explored: " + nodesExplored + " nodes");
                printPath(grid, parentX, parentY);
                return;
            }

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols) {

                    if (grid.grid[nx][ny] != '#') {

                        int newDist = dist[x][y] + 1;

                        if (newDist < dist[nx][ny]) {

                            dist[nx][ny] = newDist;
                            parentX[nx][ny] = x;
                            parentY[nx][ny] = y;

                            pq.add(new int[]{nx, ny, newDist});

                        }

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

            if (grid.grid[x][y] != 'G')
                grid.grid[x][y] = '*';

            x = px;
            y = py;
        }

        System.out.println("Path:");
        grid.printGrid();
    }
}