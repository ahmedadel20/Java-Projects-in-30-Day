import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] maze = {
            {2, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 1}
    };

    //0 --> wall
    //1 --> path
    //2 --> goal

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        Position position = new Position(0, 3);
        path.push(position);


        /*for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }*/

        int x = path.peek().getY();
        int y = path.peek().getX();

        maze[y][x] = 0;

        for (int i = y; i < maze.length; i++) {
            for (int j = x; j < maze[i].length; j++) {
                 System.out.print(maze[i][j] + " ");
             }

            //down
            if (maze[y + 1][x] == 2) {
                System.out.println("Moved down, You won!");
                return;
            } else if (maze[y + 1][x] == 1) {
                System.out.println("Moved DOWN");
                path.push(new Position(y + 1, x));
                continue;
            }

            //up
            if (maze[y - 1][x] == 2) {
                System.out.println("Moved up, You won!");
                return;
            } else if (maze[y - 1][x] == 1) {
                System.out.println("Moved UP!");
                path.push(new Position(y - 1, x));
                continue;
            }

            //right
            if (maze[y][x + 1] == 2) {
                System.out.println("Moved right, You won!");
            } else if (maze[y][x + 1] == 1) {
                System.out.println("Moved RIGHT!");
                path.push(new Position(y, x + 1));
                continue;
            }

            //left
            if (maze[y][x - 1] == 2) {
                System.out.println("Moved left, You won!");
            } else if (maze[y][x - 1] == 1) {
                System.out.println("Moved LEFT!");
                path.push(new Position(y, x - 1));
                continue;
            }

            try {
                path.pop();
            }
            catch(Exception e)
            {
                System.out.println("No Path");
            }


        }
    }
}