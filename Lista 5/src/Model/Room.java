package Model;

/**
 * Klasa reprezentująca komnate w labiryncie z 4 ścianami
 * @author Kamil
 */
public class Room{
   private  Wall north, east, south, west; 
   private boolean visited=false;
   private boolean end=false;
   
    public Wall getNorth() {
        return north;
    }

    public void setNorth(Wall north) {
        this.north = north;
    }

    public Wall getEast() {
        return east;
    }

    public void setEast(Wall east) {
        this.east = east;
    }

    public Wall getSouth() {
        return south;
    }

    public void setSouth(Wall south) {
        this.south = south;
    }

    public Wall getWest() {
        return west;
    }

    public void setWest(Wall west) {
        this.west = west;
    }
    /**
     * Czy komnata była już odwiedzona
     * @return Dostęp do komnaty
     */
    public boolean isVisited() {
        return visited;
    }
    /**
     * Ustawienie dostępu do komnaty
     * @param visited Dostęp do komnaty
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    /**
     * Czy komnata jest wyjściem z labiryntu
     * @return Wyjscie
     */
    public boolean isEnd() {
        return end;
    }
    /**
     * Ustawienie komnaty która będzie wyjściem z labiryntu
     * @param end Wyjscie
     */
    public void setEnd(boolean end) {
        this.end = end;
    }

   
} 
