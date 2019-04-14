
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    // instance variables - replace the example below with your own
    String name;
    Room[][] rooms = new Room[10][10];
    
    int currentXPos = 0;
    int currentYPos = 0;

    /**
     * Constructor for objects of class Map
     */
    public Map(String name)
    {
        this.name = name;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setRoom(Room room, int x, int y)
    {
        // put your code here
        rooms[x][y] = room;
    }
    
    public Room getCurrentRoom(int x, int y) {
        return rooms[x][y];
    }
}
