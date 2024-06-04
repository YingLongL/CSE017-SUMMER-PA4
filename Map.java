/**
 * The Map class represents a 2D map with cities.
 * It provides methods to initialize the map, find elements, and calculate paths.
 * @author  Yinglong Lin
 * @version Java 11 / VSCode
 * @since   2024-6-4 (date of last revision) 
 */
public class Map {
    private String[][] map;

    /**
     * Default constructor initializes a 10x10 map.
     */
    public Map() {
        this.map = new String[10][10];
    }

    /**
     * Constructor initializes a map with specified rows and columns.
     * @param rows the number of rows in the map
     * @param cols the number of columns in the map
     */
    public Map(int rows, int cols) {
        this.map = new String[rows][cols];
    }

    /**
     * Constructor initializes the map with a given 2D array.
     * @param initMap a 2D array to initialize the map
     */
    public Map(String[][] initMap) {
        this.map = new String[initMap.length][initMap[0].length];
        for (int i = 0; i < initMap.length; i++) {
            for (int j = 0; j < initMap[i].length; j++) {
                this.map[i][j] = initMap[i][j];
            }
        }
    }

    /**
     * Returns the number of rows in the map.
     * @return the number of rows
     */
    public int getRows() {
        return this.map.length;
    }

    /**
     * Returns the number of columns in the map.
     * @return the number of columns
     */
    public int getColumns() {
        return this.map[0].length;
    }

    /**
     * Returns the element at the specified row and column.
     * @param row the row index
     * @param col the column index
     * @return the element at the specified position
     * @throws ArrayIndexOutOfBoundsException if the row or column index is out of bounds
     */
    public String getElement(int row, int col) {
        if (row < 0 || row >= this.map.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index for the row " + row + ", length = " + this.map.length);
        }
        if (col < 0 || col >= this.map[0].length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index for the column " + col + ", length = " + this.map[0].length);
        }
        return this.map[row][col];
    }

    /**
     * Finds the coordinates of the specified city in the map.
     * @param city the name of the city to find
     * @return the coordinates of the city, or null if not found
     */
    public Coordinate findElement(String city) {
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                if (this.map[i][j].equals(city)) {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Finds a path from one city to another, moving only right or down.
     * @param element1 the starting city
     * @param element2 the destination city
     * @return a string representing the path, or a message if no path is found
     */
    public String findPath(String element1, String element2) {
        Coordinate start = findElement(element1);
        Coordinate end = findElement(element2);
        if (start == null || end == null) {
            return "No Path found from " + element1 + " to " + element2;
        }
        String path = findPath(start, end);
        if (path.isEmpty()) {
            return "No Path found from " + element1 + " to " + element2;
        } else {
            return "Path found: - " + path;
        }
    }

    /**
     * Helper method to recursively find a path from start to end.
     * @param start the starting coordinates
     * @param end the ending coordinates
     * @return a string representing the path, or an empty string if no path is found
     */
    private String findPath(Coordinate start, Coordinate end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return map[start.getX()][start.getY()];
        }
        if (start.getX() >= this.map.length || start.getY() >= this.map[0].length) {
            return "";
        }

        String rightPath = findPath(new Coordinate(start.getX(), start.getY() + 1), end);
        if (!rightPath.isEmpty()) {
            return map[start.getX()][start.getY()] + " - " + rightPath;
        }
        
        String downPath = findPath(new Coordinate(start.getX() + 1, start.getY()), end);
        if (!downPath.isEmpty()) {
            return map[start.getX()][start.getY()] + " - " + downPath;
        }

        return "";
    }

    /**
     * Counts the number of possible paths from one city to another, moving only right or down.
     * @param element1 the starting city
     * @param element2 the destination city
     * @return the number of possible paths
     */
    public int countPaths(String element1, String element2) {
        Coordinate start = findElement(element1);
        Coordinate end = findElement(element2);
        if (start == null || end == null) {
            return 0;
        }
        return countPaths(start, end);
    }

    /**
     * Helper method to recursively count the number of paths from start to end.
     * @param start the starting coordinates
     * @param end the ending coordinates
     * @return the number of possible paths
     */
    private int countPaths(Coordinate start, Coordinate end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            return 1;
        }
        if (start.getX() >= this.map.length || start.getY() >= this.map[0].length) {
            return 0;
        }
        return countPaths(new Coordinate(start.getX() + 1, start.getY()), end) +
               countPaths(new Coordinate(start.getX(), start.getY() + 1), end);
    }

    /**
     * Returns a string representation of the map.
     * @return the map as a formatted string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                sb.append(String.format("%-15s", this.map[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}