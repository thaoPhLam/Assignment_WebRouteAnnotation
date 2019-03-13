package basecode;

import annotation.WebRoute;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Routes implements HttpHandler {
    @WebRoute(path = "/test")
    public String test1(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
        return response;
    }
/*
//TODO: csináljak külön osztályt az egyes route-oknak?
    @WebRoute(path = "/another")
    public String test2(HttpExchange t) throws IOException {
        String response = "This is ANOTHER response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
        return response;
    }
*/
    public void handle(HttpExchange httpExchange) throws IOException {
        test1(httpExchange);
        //test2(httpExchange);
    }
}
