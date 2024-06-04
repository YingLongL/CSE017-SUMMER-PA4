/**
 * The Coordinate class represents a point in a 2D coordinate system.
 * It has two integer fields, x and y, representing the x and y coordinates.
 * @author  Yinglong Lin
 * @version Java 11 / VSCode
 * @since   2024-6-4 (date of last revision) 
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Default constructor initializes x and y to 0.
     */
    public Coordinate() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor with two arguments to initialize x and y.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the value of x coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the value of y coordinate.
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of x coordinate.
     * @param x the new value for x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the value of y coordinate.
     * @param y the new value for y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the coordinate as a formatted string.
     * @return a string representation of the coordinate in the format (x, y)
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}