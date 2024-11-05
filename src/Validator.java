import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public boolean isValidKey(int key, char[] alphabet) {
        // Проверка ключа
        return false;
    }
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
}
