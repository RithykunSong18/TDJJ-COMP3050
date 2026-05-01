import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TileMap {
    private static final String[] MAP_FILE_CANDIDATES = {
        "main/map.txt",
        "map.txt"
    };

    private final char[][] tiles;
    private final int height;
    private final int width;

    public TileMap() throws IOException {
        Path mapPath = null;
        for (String candidate : MAP_FILE_CANDIDATES) {
            Path path = Path.of(candidate);
            if (Files.exists(path)) {
                mapPath = path;
                break;
            }
        }

        if (mapPath == null) {
            throw new IllegalArgumentException("Map file not found.");
        }

        List<String> rows = Files.readAllLines(mapPath)
            .stream()
            .filter(line -> !line.isBlank())
            .toList();

        this.height = rows.size();
        this.width = rows.get(0).length();
        this.tiles = new char[height][width];

        for (int y = 0; y < height; y++) {
            String row = rows.get(y);
            for (int x = 0; x < width; x++) {
                tiles[y][x] = row.charAt(x);
            }
        }
    }

    public boolean isInBounds(int y, int x) {
        return y >= 0 && y < height && x >= 0 && x < width;
    }

    public char getTileOrBlank(int y, int x) {
        if (!isInBounds(y, x)) return ' ';
        return tiles[y][x];
    }

    public boolean isBlocking(int y, int x) {
        if (!isInBounds(y, x)) return true;
        char tile = tiles[y][x];
        return tile == 'B' || tile == 'D' || tile == 'S' || tile == 'W';
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }
}
