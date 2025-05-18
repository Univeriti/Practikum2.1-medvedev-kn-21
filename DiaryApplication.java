import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import utils.FilesystemUtilities;

public class DiaryApplication {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String filename = "diary.txt";

        System.out.println("1 - Додати запис");
        System.out.println("2 - Переглянути записи");
        System.out.print("Обери дію: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Введи текст запису: ");
            String entry = scanner.nextLine();
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            FilesystemUtilities.saveToFile(filename, time + " — " + entry);
            System.out.println("Запис збережено.");
        } else if (choice.equals("2")) {
            String content = FilesystemUtilities.readFromFile(filename);
            System.out.println("=== Всі записи ===");
            System.out.println(content);
        } else {
            System.out.println("Невірна дія.");
        }
    }
}
