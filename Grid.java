import java.util.Random;

public class Grid {

    int rows = 10;
    int cols = 10;
    char[][] grid = new char[rows][cols];

    int startX = 0;
    int startY = 0;

    int goalX = 9;
    int goalY = 9;

    public Grid() {

        Random rand = new Random();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(rand.nextInt(5) == 0){
                    grid[i][j] = '#'; // obstacle
                }else{
                    grid[i][j] = '.';
                }

            }
        }

        grid[startX][startY] = 'S';
        grid[goalX][goalY] = 'G';
    }

    public void printGrid(){

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                System.out.print(grid[i][j] + " ");

            }
            System.out.println();
        }

    }

}