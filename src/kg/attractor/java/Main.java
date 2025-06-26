package kg.attractor.java;

import kg.attractor.java.lesson44.Lesson44Server;
import kg.attractor.java.lesson44.Lesson45Server;
import kg.attractor.java.utils.JsonUtils;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            new Lesson45Server("localhost", 8080).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
