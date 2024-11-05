import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserChoiceScanner {

    protected static void showMenu() {
        System.out.println("Здравствуйте!");
        System.out.println("Выберите действие:");
        System.out.println("1. Зашифровать текст с помощью ключа");
        System.out.println("2. Расшифровать текст с помощью ключа");
        System.out.println("3. Осуществить перебор с помощью brute force");
        System.out.println("4. Найти ключ автоматически");
        System.out.println("0. Выход");
    }

    protected static int getUserChoice(Scanner scanner) {
        System.out.print("Ваш выбор: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Пожалуйста, введите число.");
            scanner.next(); // Пропускаем некорректный ввод
            System.out.print("Ваш выбор: ");
        }
        return scanner.nextInt();
    }

    protected static String getUserPathRead(Scanner scanner, String message) {
        String path;
        while (true) {
            System.out.print(message);
            path = scanner.nextLine();
            Path filePath = Paths.get(path);
            if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
                return path; // Возвращаем корректный путь к файлу
            } else {
                System.out.println("Ошибка: Указанный файл не существует или это директория. Пожалуйста, попробуйте снова.");
            }
        }
    }

    protected static String getUserPathWrite(Scanner scanner, String message) {
        String path;
        while (true) {
            System.out.print(message);
            path = scanner.nextLine();
            Path filePath = Paths.get(path);

            if (Files.exists(filePath)) {
                System.out.print("Файл уже существует. Вы хотите перезаписать его? (да/нет): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("да")) {
                    return path; // Позволяем перезапись
                } else {
                    System.out.println("Пожалуйста, укажите другой путь к файлу для записи.");
                }
            } else {
                // Если файла не существует, можно создать новый
                return path; // Возвращаем путь для нового файла
            }
        }
    }

    protected static int getUserKey(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Пожалуйста, введите число.");
            scanner.next(); // Пропускаем некорректный ввод
        }
        return scanner.nextInt();
    }
}
