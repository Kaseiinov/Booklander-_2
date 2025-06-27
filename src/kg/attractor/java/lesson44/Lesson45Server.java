package kg.attractor.java.lesson44;

import com.sun.net.httpserver.HttpExchange;
import kg.attractor.java.server.ContentType;
import kg.attractor.java.server.ResponseCodes;
import kg.attractor.java.server.models.Book;
import kg.attractor.java.server.models.User;
import kg.attractor.java.utils.JsonUtils;
import kg.attractor.java.utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.util.*;

public class Lesson45Server extends Lesson44Server {
    private Optional<User> loggedUser = Optional.of(new User());

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);
        registerGet("/register", this::registerGet);
        registerPost("/register", this::registerPost);
        registerGet("/profile", this::profileGetFreemarkerHandler);
    }

    private void profileGetFreemarkerHandler(HttpExchange exchange){
        renderTemplate(exchange, "profile.ftlh", getUserProfileDataModel(loggedUser.orElse(null)));
    }

    private Map<String, User> getUserProfileDataModel(User user) {
        Map<String, User> mapUser = new HashMap<>();
        mapUser.put("user", user);
        return mapUser;
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
                    "%s -> code response " +
                    "<a href='/register'>try again</a>";
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
        URI uri = exchange.getRequestURI();
        if(uri.getQuery() != null){
            Map<String, String> response = Utils.parseUrlEncoded(uri.getQuery(), "&");;
            renderTemplate(exchange, "login.ftlh", response);
            return;
        }
        Path path = makeFilePath("login.ftlh");
        sendFile(exchange, path, ContentType.TEXT_HTML);
    }

    private void loginPost(HttpExchange exchange) {
        String raw = getBody(exchange);
        Map<String, String> parsed = Utils.parseUrlEncoded(raw, "&");


        if(User.getUsers().stream().anyMatch(e -> e.getEmail().equals(parsed.get("email")))) {
            Optional<User> user = User.getUsers().stream().filter(e -> e.getEmail().equals(parsed.get("email"))).findFirst();
            if(user.get().getPassword().equals(parsed.get("user-password"))){
                loggedUser = user;
                redirect(exchange, "/profile");
            }else {
                redirect(exchange, "/login?response=Incorrect password");
            }
        }else{
            redirect(exchange, "/login?response=User not found");
        }

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
