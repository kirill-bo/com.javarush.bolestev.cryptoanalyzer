import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainApp {

    public static void main(String[] args) {

        String s = "C:\\Users\\natal\\Downloads\\com.javarush.bolestev.cryptoanalyzer\\src\\Notes\\";
        int keyFromUser = Validator.getKeyFromUser("4");

        // Шифрование
        FileManager.writeFile(Cipher.encrypt(FileManager.readFile(s + "Hamlet.txt", StandardCharsets.UTF_8), keyFromUser),
                s + "CipHam.txt", false);

        //Определяем наиболее вероятный ключ
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
        int key = statisticalAnalyzer.findMostLikelyShift(FileManager.readFile(s + "CipHam.txt", StandardCharsets.UTF_8),
                Alphabet.CYRILLIC.getAlphabet(), "о, е, а, и, н, т, с, р, в");
        System.out.println(key);

        //Расшифровка
        FileManager.writeFile(Cipher.decrypt(FileManager.readFile(s + "CipHam.txt", StandardCharsets.UTF_8), key),
                s + "DeCipHam.txt", false);

        //Грубая расшифровка. Записываем все варианты в один файл
        FileManager.writeFile(BruteForce.decryptByBruteForce(FileManager.readFile(s + "CipHamBruteForce.txt",
                        StandardCharsets.UTF_8), Alphabet.CYRILLIC.getAlphabet()),
                "DeCipHam.txt", true);

    }
}
