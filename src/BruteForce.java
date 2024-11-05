import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {

    // Метод для расшифровки текст с использованием метода грубой силы
    public static void decryptByBruteForce(String encryptedText, char[] alphabet, String file, boolean b) {
        StringBuilder result = new StringBuilder();

        if (encryptedText == null) {
            throw new IllegalArgumentException("Зашифрованный текст не может быть null");
        }
        if (b) {
            // Пробуем все возможные сдвиги от 1 до длины алфавита
            for (int shift = 1; shift < alphabet.length; shift++) {
                String decryptedText = Cipher.decrypt(encryptedText, shift);
                result.append("Сдвиг ").append(shift).append(": ").append(decryptedText).append("\n");
                FileManager.writeFile(decryptedText, file + shift + ".txt", false);
            }
        } else if (!b) {
            // Пробуем все возможные сдвиги от 1 до длины алфавита
            for (int shift = 1; shift < alphabet.length; shift++) {
                String decryptedText = Cipher.decrypt(encryptedText, shift);
                result.append("Сдвиг ").append(shift).append(": ").append(decryptedText).append("\n");

            }
            FileManager.writeFile(result.toString(), file, false);
        }
    }
}
