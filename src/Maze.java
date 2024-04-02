import java.util.LinkedList;

public class Maze {
    public int[][] maze;
    public LinkedList<Position> path;
    private Position start;

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public LinkedList<Position> getPath() {
        return path;
    }

    public void setPath(LinkedList<Position> path) {
        this.path = path;
    }

    public Position getStart() {
        return start;
    }

    public void setStart(Position start) {
        this.start = start;
    }
}
