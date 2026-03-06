import java.awt.*;
import javax.swing.*;

public class Visualizer extends JFrame {

    char[][] grid;

    public Visualizer(char[][] grid) {
        this.grid = grid;

        setTitle("Pathfinding Visualizer");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GridPanel());
        setVisible(true);
    }

    class GridPanel extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int rows = grid.length;
            int cols = grid[0].length;

            int cellSize = 40;

            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){

                    if(grid[i][j] == '#')
                        g.setColor(Color.BLACK);

                    else if(grid[i][j] == 'S')
                        g.setColor(Color.GREEN);

                    else if(grid[i][j] == 'G')
                        g.setColor(Color.RED);

                    else if(grid[i][j] == '*')
                        g.setColor(Color.YELLOW);
                    else if(grid[i][j] == 'v')
                        g.setColor(Color.CYAN);

                    else
                        g.setColor(Color.WHITE);

                    g.fillRect(j*cellSize, i*cellSize, cellSize, cellSize);

                    g.setColor(Color.GRAY);
                    g.drawRect(j*cellSize, i*cellSize, cellSize, cellSize);
                }
            }
        }
    }
}