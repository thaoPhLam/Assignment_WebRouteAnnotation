package basecode;

import annotation.WebRoute;
import com.sun.net.httpserver.HttpServer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class Test {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        for (Method method : Routes.class.getMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute webRoute = (WebRoute) annotation;

                server.createContext(webRoute.path(), new WebServer((String) method.invoke(Routes.class.newInstance(), null)));
            }
        }

        server.setExecutor(null); // creates a default executor
        server.start();

    }
}