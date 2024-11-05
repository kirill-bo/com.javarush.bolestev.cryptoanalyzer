public class BruteForce {

    // Метод для расшифровки текст с использованием метода грубой силы
    public static String decryptByBruteForce(String encryptedText, char[] alphabet) {
        StringBuilder result = new StringBuilder();

        if (encryptedText == null) {
            throw new IllegalArgumentException("Зашифрованный текст не может быть null");
        }
        // Пробуем все возможные сдвиги от 1 до длины алфавита
        for (int shift = 1; shift < alphabet.length; shift++) {
            String decryptedText = Cipher.decrypt(encryptedText, shift);
            result.append("Сдвиг ").append(shift).append(": ").append(decryptedText).append("\n");
        }
        return result.toString();
    }
}

