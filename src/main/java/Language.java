import java.io.*;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class Language {

    /**
     * This method reads a .txt file with a specific setup and returns a HashMap<String, String> with the content
     * (Use English.txt as reference. Uneven numbered lines are keywords for the even lines under them which contains the respective string texts)
     * @param language String to change the .txt file path you get in the switch case extra cases can be added for more languages.
     * @return Returns the HashMap<String, String> with the content of the file loaded.
     * @throws IOException
     */
    public static HashMap<String, String> languageInit(String language) throws IOException {

        Path path;
        switch (language.toLowerCase()) {
            case "danish":
                path = Paths.get("Danish.txt");
            break;
            default: path = Paths.get("English.txt");
        }
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path.toAbsolutePath())));

        HashMap<String, String> langList = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            langList.put(reader.readLine(), reader.readLine());

        }
        return langList;
    }

    /**
     * Returns an array that loads the tileTextx lines from the HashMap into an array.
     * @param stringList HashMap containing language strings
     * @return Returns a String[] of the tiletexts.
     */

    public static String[] tileTexts(HashMap<String, String> stringList){
        String[] tileText = new String[13];
        for (int i = 1 ; i < 13; i++) {
            tileText[i] = stringList.get("tileText"+i);
        }
        return tileText;
    }

}
