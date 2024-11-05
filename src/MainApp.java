import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainApp {

    public static void main(String[] args) throws IOException {

        String s = "C:\\Users\\natal\\Downloads\\com.javarush.bolestev.cryptoanalyzer\\src\\Notes\\";

        //Логика для выбора режима работы, вызов соответствующих методов
        //FileManager.writeFile(Cipher.encrypt(FileManager.readFile(s + "Hamlet.txt", StandardCharsets.UTF_8), 5),
        //    s + "CipHam.txt", false);
        // FileManager.writeFile(Cipher.decrypt(FileManager.readFile(s + "CipHam.txt", StandardCharsets.UTF_8), 2),
        //        s + "DeCipHam.txt", false);
        // FileManager.writeFile(BruteForce.decryptByBruteForce(FileManager.readFile(s + "CipHam.txt", StandardCharsets.UTF_8), ALPHABET),
        //           "DeCipHam.txt", true);
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
        int key = statisticalAnalyzer.findMostLikelyShift(FileManager.readFile(s + "CipHam.txt", StandardCharsets.UTF_8),
                Alphabet.CYRILLIC.getAlphabet(), "о, е, а, и, н, т, с, р, в");
        System.out.println(key);
    }
}
