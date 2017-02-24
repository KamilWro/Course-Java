package Model;

import java.util.Arrays;
import java.util.Collections;

/**
 * Generowanie Labiryntu
 * @author kamil
 */
public class Maze{
    private int size;
    private Room[][] rooms;
    boolean start=true;
	
    public Maze(int size, Room[][] rooms) {        
        this.size = size;
        this.rooms=rooms;
        initialRooms();
        generateMaze(0,0);
   }
    
    private void generateMaze(int cx, int cy) {
		Direction [] dirs = Direction.values();
		Collections.shuffle(Arrays.asList(dirs));
		for (Direction dir : dirs) {
			int nx = cx + dir.dx;
			int ny = cy + dir.dy;
			if (between(nx, size) && between(ny, size) && (rooms[nx][ny].isVisited() == false)) {
				rooms[nx][ny].setVisited(true);
                                if (dir==Direction.N) rooms[cx][cy].getNorth().setIsGone(true);
                                if (dir==Direction.S) rooms[cx][cy].getSouth().setIsGone(true);
                                if (dir==Direction.E) rooms[cx][cy].getEast().setIsGone(true);
                                if (dir==Direction.W) rooms[cx][cy].getWest().setIsGone(true);
                                generateMaze(nx, ny);
			}
		}
	}
        
    private static boolean between(int v, int upper) {
		return (v >= 0) && (v < upper);
	}
    
    private enum Direction {
		N(-1, 0), S(1, 0), E(0, 1), W(0, -1);
		private final int dx;
		private final int dy;
 
		private Direction(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
	}  
    
    private void initialRooms() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                rooms[i][j]=new Room();
                if (i == 0) {
                    rooms[i][j].setNorth(new Wall());
                } else {
                    Wall x=new Wall();
                    rooms[i][j].setNorth(x);
                    rooms[i-1][j].setSouth(x);
                }
                if (i == size - 1) {
                    rooms[i][j].setSouth(new Wall());
                }
                if (j == 0) {
                    rooms[i][j].setWest(new Wall());
                } else {
                    Wall x=new Wall();
                    rooms[i][j].setWest(x);
                    rooms[i][j-1].setEast(x);
                }
                if (j == size - 1) {
                    rooms[i][j].setEast(new Wall());
                }
            }
        }

        rooms[0][0].getWest().setIsGone(true);
        rooms[0][0].setEnd(true);
        rooms[0][0].setVisited(true);
    }
    
}