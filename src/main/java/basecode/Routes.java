package basecode;

import annotation.WebRoute;

public class Routes {
    @WebRoute(path = "/test")
    public String test1() {
        String response = "This is the response";
        return response;
    }

    @WebRoute(path = "/another")
    public String test2() {
        String response = "This is ANOTHER response";
        return response;
    }

/*
TODO: Extra features
    @WebRoute(method = WebRoute.Method.POST, path = "/users")
    public String onTest() {

    }

    @WebRoute(path = "/user/<userName>")
    public String onTest(String userName) {

    }
*/
}
