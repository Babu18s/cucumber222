package JsonReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
/*
Reading data From the JsonFile
*/
public class ReadingDataFromJson {
    public String readFile(String attribute) throws Exception {
        JsonParser jsonParser = new JsonParser();

        FileReader read = new FileReader("C:\\Users\\Ravibabu Singavarapu\\IdeaProjects\\CucumberAssignment\\src\\test\\JsonFile\\TestData.json");

        Object obj = jsonParser.parse (read);

        JsonObject jsonObject =(JsonObject) obj;
        String value =jsonObject.get(attribute).getAsString();
        return value;
    }
}

