package kg.attractor.java.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import kg.attractor.java.lesson44.SampleDataModel;
import kg.attractor.java.server.models.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                @Override
                public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
                                             JsonDeserializationContext context) throws JsonParseException {
                    return LocalDate.parse(json.getAsString());
                }
            })
            .create();
    private final String dir = "data/json/";

    public List<Book> readBooks() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(dir + "books.json"));

        Type listType = new TypeToken<List<Book>>(){}.getType();
        List<Book> books = gson.fromJson(reader, listType);
        return books;
    }

    public List<SampleDataModel.User> readUsers() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(dir + "users.json"));

        Type listType = new TypeToken<List<SampleDataModel.User>>(){}.getType();
        List<SampleDataModel.User> users = gson.fromJson(reader, listType);
        return users;
    }
}
