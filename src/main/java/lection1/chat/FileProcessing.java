package lection1.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessing {

    public void fileWrite(String fileName, String message) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<String> fileRead(String fileName) {
        List<String> result = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
