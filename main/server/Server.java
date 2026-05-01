import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {
    public static void main(String[] args) throws Exception {
        TileMap tileMap = new TileMap();
        GameState gameState = new 
GameState(5,6);
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/info", new InfoHandler(tileMap, gameState));
        server.createContext("/move", new MoveHandler(tileMap, gameState));
        server.setExecutor(null);
        server.start();
        System.out.println("Server running on port 8000");
    }
}
