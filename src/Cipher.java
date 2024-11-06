


public class Cipher {


    // Метод для получения индекса символа в алфавите
    private static int indexOf(char ch) {
        for (int i = 0; i < Alphabet.CYRILLIC.getAlphabet().length; i++) {
            if (Alphabet.CYRILLIC.getAlphabet()[i] == ch) {
                return i;
            }
        }
        return -1; // символ не найден
    }

    // Метод для шифрования текста
    public static String encrypt(String text, int shift) {

        if (text == null) {
            throw new IllegalArgumentException("Текст не может быть null");
        }
        // Логика шифрования
        StringBuilder result = new StringBuilder(); //Создает новый объект StringBuilder для хранения результата
        int alphabetLength = Alphabet.CYRILLIC.getAlphabet().length;
        shift = ((shift % alphabetLength) + alphabetLength) % alphabetLength;
        // Проходим по каждому символу текста
        for (char ch : text.toCharArray()) {
            int index = indexOf(ch); //Вызывает indexOf(ch) для получения индекса символа
            if (index != -1) {
                // Если символ найден, сдвигаем его
                int newIndex = (index + shift) % alphabetLength;
                result.append(Alphabet.CYRILLIC.getAlphabet()[newIndex]);
            } else {
                // если символ не в алфавите, добавляем его без изменений
                result.append(ch);
            }
        }
        return result.toString();
    }

/* для работы с алфавитом из диапазона таблицы

        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (text == null) return "";
            {
                int originalAlphabetPosition = character - 'а';
                System.out.println(originalAlphabetPosition);
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 26;
                System.out.println(newAlphabetPosition);
                char newCharacter = (char) ('a' + newAlphabetPosition);
                System.out.println(newCharacter);
                result.append(newCharacter);
            }
        }
        return result.toString();
         }
*/

    /*  Для работы с любым символом

            if (text == null) return "";
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new StringReader(text));

            String string = bufferedReader.readLine();

            for (char c : string.toCharArray()) {
                sb.append((char) (c + shift));
            }

            return sb.toString();
        }
    */

    // Метод для дешифрования текста
    public static String decrypt(String encryptedText, int shift) {
        if (encryptedText == null) {
            throw new IllegalArgumentException("Зашифрованный текст не может быть null");
        }
        // Логика расшифровки
        return encrypt(encryptedText, -shift);
    }
}
