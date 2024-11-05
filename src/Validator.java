import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    // Вспомогательный метод для проверки пути к файлу
    protected static void validateFilePath(String filePath) {
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IllegalArgumentException("Путь к файлу не может быть null или пустым.");
        }
    }

    // Вспомогательный метод для проверки существования файла
    protected static void checkFileExists(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + path);
        }
        if (!Files.isRegularFile(path)) {
            throw new IOException("Указанный путь не является файлом: " + path);
        }
    }

    //Проверка что ключь число
    protected static int getKeyFromUser(String sKey) {
        int key = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                key = Integer.parseInt(sKey); // Пробуем преобразовать введенное значение в число
                validInput = true; // Если преобразование успешно, выходим из цикла
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ключ должен быть числом."); // Обрабатываем неверный ввод
            }
        }
        return key; // Возвращаем
    }
}
