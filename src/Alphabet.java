public enum Alphabet {

    CYRILLIC(new char[] {
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
            'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
            'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',',
            '«', '»', '"', '\\', ':', '!', '?', ' '
    });

    private final char[] alphabet;

    Alphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public char[] getAlphabet() {
        return alphabet;
    }
}
