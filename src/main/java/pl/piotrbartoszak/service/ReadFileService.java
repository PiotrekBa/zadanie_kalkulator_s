package pl.piotrbartoszak.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileService {

    private static final String FILENAME = "src/main/resources/file/countries.txt";

    public static List<String> readFile() {
        List<String> fileLines = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                if(!currentLine.startsWith("/")) {
                    fileLines.add(currentLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }

                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return fileLines;
    }
}
