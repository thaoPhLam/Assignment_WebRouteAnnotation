package basecode;

import annotation.WebRoute;
import com.sun.net.httpserver.HttpServer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        //server.createContext("/test", new MyHandler());
        //server.createContext("/another", new AnotherMyHandler());

        /**
         * itt kezdődik az assignment
         *
         * Process Routes
         */
        for (Method method : Routes.class.getMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute webRoute = (WebRoute) annotation;
                /*
                Here comes your logic.
                If the given path from the HttpExchange method
                is the SAME like the WebRoute annotation's path,
                you should INVOKE this method.
                */
                server.createContext(webRoute.path(), new Routes());

            }
        }

        server.setExecutor(null); // creates a default executor
        server.start();

    }
/*
    static class MyHandler implements HttpHandler {

        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class AnotherMyHandler implements HttpHandler {

        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "This is ANOTHER response";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
*/
}