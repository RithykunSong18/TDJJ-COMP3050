import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/info", new MyHandler()); //change myhandler to infohandler
        server.createContext("/move", new MyHandler()); //change myhandler to movehandler
        server.setExecutor(null); // creates a default executor
        server.start();
    }

}
