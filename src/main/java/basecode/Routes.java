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

    @WebRoute(method = WebRoute.Method.POST, path = "/users")
    public String onTest() {
        String response = "This is a POST response";
        return response;
    }
/*
TODO: Extra features
    @WebRoute(path = "/user/<userName>")
    public String onTest(String userName) {

    }
*/
}
