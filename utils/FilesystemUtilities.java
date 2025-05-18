package utils;
import java.io.*;

public class FilesystemUtilities {
    public static void saveToFile(String filename, String text) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(text + "");
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }

    public static String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            return "Файл не знайдено.";
        }
        return content.toString();
    }
}
