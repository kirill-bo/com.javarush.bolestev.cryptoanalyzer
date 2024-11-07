public class Alphabet {

    private final char[] alphabet;

    public static final Alphabet CYRILLIC = new Alphabet(new char[]{
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
            'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',',
            '«', '»', '"', '\\', ':', '!', '?', ' '
    });

    // Конструктор
    private Alphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    // Метод для получения алфавита
    public char[] getAlphabet() {
        return alphabet.clone(); // Запрет на модификацию исходного массива
    }
}