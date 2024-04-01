import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] maze = {
            {1, 0, 1, 1},
            {0, 1, 1, 0},
            {2, 0, 0, 1}
    };

    //0 --> wall
    //1 --> path
    //2 --> goal

    static LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) {
        Position position = new Position(0, 3);
        path.push(position);
        /*for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }*/
        while(true){

            int x = path.peek().getX();
            int y = path.peek().getY();
            //System.out.println(x);
            //System.out.println(y);

            maze[y][x] = 0;

            //down
            if(isValid(y+1, x)){
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down, You won!");
                    displaySolvedMaze();
                    return;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("Moved DOWN");
                    path.push(new Position(y + 1, x));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x)) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("Moved up, You won!");
                    displaySolvedMaze();
                    return;
                } else if (maze[y - 1][x] == 1) {
                    System.out.println("Moved UP!");
                    path.push(new Position(y - 1, x));
                    continue;
                }
            }

            //right
            if(isValid(y, x+1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right, You won!");
                    displaySolvedMaze();
                } else if (maze[y][x + 1] == 1) {
                    System.out.println("Moved RIGHT!");
                    path.push(new Position(y, x + 1));
                    continue;
                }
            }

            //left
            if(isValid(y, x-1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left, You won!");
                    displaySolvedMaze();
                } else if (maze[y][x - 1] == 1) {
                    System.out.println("Moved LEFT!");
                    path.push(new Position(y, x - 1));
                    continue;
                }
            }

            path.pop();
            System.out.println("Moved Back");
            if(path.isEmpty()) {
                System.out.println("No Path");
                break;
            }
        }
    }

    public static void displaySolvedMaze()
    {
        for(int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValid(int y, int x)
    {
        if(y < 0 || y >= maze.length || x < 0 || x >= maze[y].length){
            return false;
        }
        return true;
    }
}