import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
class TextAdventure {
    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "src/textChoices.json";
        Gson gson = new Gson();
        JsonObject[] arrObj = gson.fromJson(new FileReader(testFile), JsonObject[].class);
        Scanner input = new Scanner(System.in);
        int Choice = 0;
        while (true) {
            System.out.println(arrObj[Choice].get("text").getAsString());
            JsonArray options = arrObj[Choice].get("options").getAsJsonArray();
                for (int b = 0; b < options.size(); b++){
                    JsonObject option = options.get(b).getAsJsonObject();
                    System.out.println(option.get("text").getAsString() + " " + b);
            }
            int idChoice = input.nextInt();
                JsonObject option = options.get(idChoice).getAsJsonObject();
                    Choice  = option.get("nextText").getAsInt();
                    Choice  -= 1;
            }
        }
    }