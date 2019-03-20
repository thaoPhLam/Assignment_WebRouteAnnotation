package basecode;

import annotation.WebRoute;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class WebServer {
    private HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

    public WebServer() throws IOException {
    }

    public void processRoute() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Method method : Routes.class.getMethods()) {
            if (method.isAnnotationPresent(WebRoute.class)) {
                Annotation annotation = method.getAnnotation(WebRoute.class);
                WebRoute webRoute = (WebRoute) annotation;

                server.createContext(webRoute.path(), new Handler((String) method.invoke(Routes.class.newInstance())));
            }
        }

        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
