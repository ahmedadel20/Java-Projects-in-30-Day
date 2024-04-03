import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Maze m = new Maze();

    public static void main(String[] args) {
        m.setMaze(
                new int[][]{
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {2, 0, 0, 1}
                });
                //0 --> wall
                //1 --> path
                //2 --> goal
        m.setStart(new Position(0,3));
        m.setPath(new LinkedList<Position>());

        if(solveMaze(m.getStart())) {
            System.out.println("You Won!");
        }
        else{
            System.out.println("No Path");
        }
    }

    public static void displayMaze()
    {
        for(int i = 0; i < m.maze.length; i++) {
            for (int j = 0; j < m.maze[i].length; j++) {
                System.out.print(m.maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean solveMaze(Position position)
    {
        m.path.push(position);

        while(true){

            assert m.path.peek() != null;
            int x = m.path.peek().getX();
            assert m.path.peek() != null;
            int y = m.path.peek().getY();
            //System.out.println(x);
            //System.out.println(y);

            m.maze[y][x] = 0;

            //down
            if(isValid(y+1, x)){
                if (m.maze[y + 1][x] == 2) {
                    System.out.println("Moved down");
                    displayMaze();
                    return true;
                } else if (m.maze[y + 1][x] == 1) {
                    System.out.println("Moved DOWN");
                    m.path.push(new Position(y + 1, x));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x)) {
                if (m.maze[y - 1][x] == 2) {
                    System.out.println("Moved up");
                    displayMaze();
                    return true;
                } else if (m.maze[y - 1][x] == 1) {
                    System.out.println("Moved UP!");
                    m.path.push(new Position(y - 1, x));
                    continue;
                }
            }

            //right
            if(isValid(y, x+1)) {
                if (m.maze[y][x + 1] == 2) {
                    System.out.println("Moved right");
                    displayMaze();
                    return true;
                } else if (m.maze[y][x + 1] == 1) {
                    System.out.println("Moved RIGHT!");
                    m.path.push(new Position(y, x + 1));
                    continue;
                }
            }

            //left
            if(isValid(y, x-1)) {
                if (m.maze[y][x - 1] == 2) {
                    System.out.println("Moved left");
                    displayMaze();
                    return true;
                } else if (m.maze[y][x - 1] == 1) {
                    System.out.println("Moved LEFT!");
                    m.path.push(new Position(y, x - 1));
                    continue;
                }
            }

            m.path.pop();
            System.out.println("Moved Back");
            if(m.path.isEmpty()) {
                return false;
            }
        }
    }

    public static boolean isValid(int y, int x)
    {
        if(y < 0 || y >= m.maze.length || x < 0 || x >= m.maze[y].length){
            return false;
        }
        return true;
    }
}