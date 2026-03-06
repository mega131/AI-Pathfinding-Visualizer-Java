import java.util.*;

class AStar {
    static  int nodesExplored = 0;
    static class Node {
        int x, y;
        int g, h, f;
        Node parent;

        Node(int x, int y, int g, int h, Node parent) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = parent;
        }
    }

    static int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2); // Manhattan distance
    }

    public static void findPath(char[][] grid, int startX, int startY, int goalX, int goalY) {

        int n = grid.length;

        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1.f));
        boolean[][] closed = new boolean[n][n];

        open.add(new Node(startX, startY, 0,
                heuristic(startX, startY, goalX, goalY), null));

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
           
        while (!open.isEmpty()) {
            
           Node current = open.poll();
           nodesExplored++;

            if (current.x == goalX && current.y == goalY) {

                System.out.println("Goal reached using A*!");
                System.out.println("A* explored: " + nodesExplored + " nodes");
                Node temp = current;

                while (temp != null) {
                    if(grid[temp.x][temp.y] == '.')
                        grid[temp.x][temp.y] = '*';
                    temp = temp.parent;
                }

                printGrid(grid);
                return;
            }

            closed[current.x][current.y] = true;

            for (int[] d : dirs) {

                int nx = current.x + d[0];
                int ny = current.y + d[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;

                if (grid[nx][ny] == '#' || closed[nx][ny])
                    continue;

                int g = current.g + 1;
                int h = heuristic(nx, ny, goalX, goalY);

                open.add(new Node(nx, ny, g, h, current));
            }
        }

        System.out.println("No path found.");
    }

    static void printGrid(char[][] grid) {

        for (char[] row : grid) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}