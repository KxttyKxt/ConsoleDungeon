package textGridDungeon;

public class Map {

    private Coordinate[][] coordinates; // a 2D array of coordinates according to the length and width

    /**
     * The default constructor for the map class, which creates a map (or "floor") of the dungeon.
     * @return a TextGridDungeon.Map Object with a range and domain of 5
     */
    public Map() {
        coordinates = new Coordinate[5][5];
        initMap();
    }
    
    /**
     * The dynamic constructor for the map class, which creates a map (or "floor") of the dungeon.
     * 
     * @param domain the length of the coordinates plane along the x-axis
     * @param range the length of the coordinates plane along the y-axis
     * @return a TextGridDungeon.Map Object with the specified range and domain
     */
    public Map(int domain, int range) {
        coordinates = new Coordinate[range][domain];
        initMap();
    }

    /**
     * Initializes the 2D array of coordinates of a given object.
     * Used only in the constructor.
     */
    private void initMap() {
        for (int x = 0; x < coordinates.length; x++) {
            for (int y = 0; y < coordinates[x].length; y++) {
                coordinates[x][y] = new Coordinate();
            }
        }
    }

    public void printMap() {
        String horizontalBorder = "==";
        for (Coordinate checker : coordinates[0]) {
            horizontalBorder += "=====";
        }
        System.out.println(horizontalBorder);
        for (Coordinate[] x : coordinates) {
            System.out.print("|");
            for (Coordinate y : x) {
                System.out.print("  " + y.getSymbol() + "  ");
            }
            System.out.println("|");
        }
        System.out.println(horizontalBorder + "\n");
    }
}
