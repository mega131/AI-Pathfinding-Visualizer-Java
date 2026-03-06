public class Main {

    public static void main(String[] args) {

        Grid grid = new Grid();

        System.out.println("Generated Grid:");
        grid.printGrid();

        System.out.println("\nRunning BFS...");
        BFS bfs = new BFS();
        bfs.findPath(grid);

        System.out.println("\nRunning Dijkstra...");
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.findPath(grid);

        System.out.println("\nRunning A*...");
        AStar astar = new AStar();
       astar.findPath(grid.grid, grid.startX, grid.startY, grid.goalX, grid.goalY);
        System.out.println("\nAlgorithm Comparison:");
        System.out.println("BFS nodes explored: " + bfs.nodesExplored);
        System.out.println("Dijkstra nodes explored: " + dijkstra.nodesExplored);
        System.out.println("A* nodes explored: " + AStar.nodesExplored);
        new Visualizer(grid.grid);
    }

}