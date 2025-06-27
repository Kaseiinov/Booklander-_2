package kg.attractor.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import kg.attractor.java.server.ContentType;
import kg.attractor.java.server.ResponseCodes;
import kg.attractor.java.server.models.User;
import kg.attractor.java.utils.Utils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;

public class Lesson45Server extends Lesson44Server {

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
        registerGet("/register", this::registerGet);
        registerPost("/register", this::registerPost);
    }

    private void registerPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
        User newUser = new User();
        newUser.setEmail(parsed.get("email"));
        newUser.setPassword(parsed.get("user-password"));
        newUser.setFirstName(parsed.get("user-firstName"));
        newUser.setLastName(parsed.get("user-lastName"));

        if(User.getUsers().contains(newUser)){
            String fmt = "%s -> user with that email already registered! " +
                    "%s -> code response";
            sendResponse(exchange, fmt, newUser.getEmail(), ResponseCodes.CONFLICT.getCode());
        } else{
            User.getUsers().add(newUser);
            String fmt = "%s -> user with that email successfully registered! " +
                    "%s -> code response";
            sendResponse(exchange, fmt, newUser.getEmail(), ResponseCodes.OK.getCode());
        }
        User.getUsers().forEach(e -> System.out.println("registered -> " + e.getEmail()));
    }

    private void registerGet(HttpExchange exchange){
        Path path = makeFilePath("register.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void loginGet(HttpExchange exchange){
        Path path = makeFilePath("login.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void loginPost(HttpExchange exchange) {
//        String cType = getContentType(exchange);
//        String raw = getBody(exchange);
//        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");
//
//        String fmt = "<p>Необработанные данные: <b>%s</b></p>"
//                + "<p>Content-type: <b>%s</b></p>"
//                + "<p>После обработки: <b>%s</b></p>";
//
//        String data = String.format(fmt, raw, cType, parsed);
//
//        try {
//            sendByteData(exchange, ResponseCodes.OK,
//                    ContentType.TEXT_HTML, data.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        redirect(exchange, "/");

    }

    public void sendResponse(HttpExchange exchange, String fmt, String value, int code){
        String data = String.format(fmt, value, code);
        try {
            sendByteData(exchange, ResponseCodes.OK,
                    ContentType.TEXT_HTML, data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
