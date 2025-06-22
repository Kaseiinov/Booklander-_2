package kg.attractor.java;

import kg.attractor.java.lesson44.Lesson44Server;
import kg.attractor.java.utils.JsonUtils;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            new Lesson44Server("localhost", 9889).start();
            JsonUtils json = new JsonUtils();
            json.readBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
