import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileManager {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    // Метод для чтения содержимого файла
    public static String readFile(String filePath, Charset charset) {
        // Валидация входящих данных
        Validator.validateFilePath(filePath);
        // Использование заданной кодировки или по умолчанию
        Charset effectiveCharset = (charset != null) ? charset : DEFAULT_CHARSET;

        try {
            Path path = Paths.get(filePath);
            Validator.checkFileExists(path);

            return Files.readString(path, effectiveCharset);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + e.getMessage(), e);
        }
    }

    // Метод для записи содержимого в файл
    public static void writeFile(String content, String filePath, boolean append) {
        // Валидация входящих данных
        Validator.validateFilePath(filePath);
        if (content == null) {
            throw new IllegalArgumentException("Содержимое не может быть null.");
        }
        try {
            Path path = Paths.get(filePath);

            // Определяем режим записи
            if (append) {
                //если файла не существует, создаем его. Если try и файл существвет то записываем в конец файла
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else {
                //если файла не существует, создаем его. Если false и файл сущетвует то перезаписываем его
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл: " + e.getMessage(), e);
        }
    }
}

