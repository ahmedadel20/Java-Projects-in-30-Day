import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int[][] maze = {
        {2,0,1,1},
        {1,1,0,1},
        {0,1,1,1}
    };

    //0 --> wall
    //1 --> path
    //2 --> goal

    static LinkedList<Position> path = new LinkedList<Position>();
    public static void main(String[] args) {
        Position position = new Position(3,0);
        path.push(position);

        maze[path.peek().getY()][path.peek().getX()] = 0;

        for (int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
}