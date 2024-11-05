import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalyzer {

    // Метод для поиска наиболее вероятного сдвига
    public int findMostLikelyShift(String encryptedText, char[] alphabet, String representativeText) {
        if (encryptedText == null || representativeText == null) {
            throw new IllegalArgumentException("Зашифрованный или представительный текст не может быть null");
        }

        // Частотная карта зашифрованного текста
        Map<Character, Integer> encryptedFrequencyMap = buildFrequencyMap(encryptedText);
        // Частотная карта представительного текста
        Map<Character, Integer> representativeFrequencyMap = buildFrequencyMap(representativeText);

        // Находим сдвиг
        double bestMatchScore = Double.NEGATIVE_INFINITY;
        int bestShift = 0;

        for (int shift = 0; shift < alphabet.length; shift++) {
            double matchScore = calculateMatchScore(encryptedFrequencyMap, representativeFrequencyMap, shift);
            if (matchScore > bestMatchScore) {
                bestMatchScore = matchScore;
                bestShift = shift;
            }
        }

        return bestShift;
    }

    // Метод для построения частотной карты
    private Map<Character, Integer> buildFrequencyMap(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        return frequencyMap;
    }

    // Метод для расчета оценки соответствия (match score)
    private double calculateMatchScore(Map<Character, Integer> encryptedMap,
                                       Map<Character, Integer> representativeMap, int shift) {
        double score = 0.0;
        for (Map.Entry<Character, Integer> entry : representativeMap.entrySet()) {
            char representativeChar = entry.getKey();
            int representativeFrequency = entry.getValue();
            char shiftedChar = shiftCharacter(representativeChar, shift);

            // Находим частоту зашифрованного символа
            int encryptedFrequency = encryptedMap.getOrDefault(shiftedChar, 0);
            score += (encryptedFrequency / (double) (encryptedMap.size() + 1)) * representativeFrequency;
        }
        return score;
    }

    // Вспомогательный метод для сдвига символа
    private char shiftCharacter(char ch, int shift) {
        int index = indexOf(ch);
        return index == -1 ? ch : Alphabet.CYRILLIC.getAlphabet()[(index + shift) % Alphabet.CYRILLIC.getAlphabet().length];
    }

    // Вспомогательный метод для нахождения индекса буквы в алфавите
    private int indexOf(char ch) {
        for (int i = 0; i < Alphabet.CYRILLIC.getAlphabet().length; i++) {
            if (Alphabet.CYRILLIC.getAlphabet()[i] == ch) {
                return i;
            }
        }
        return -1; // символ не найден
    }
}