import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainApp {
    static String pathRead;
    static String pathWrite;
    static int keyDecrypt;
    static int keyEncrypt;
    static boolean aBoolean = true;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            UserChoiceScanner.showMenu();
            int choice = UserChoiceScanner.getUserChoice(scanner);

            switch (choice) {
                case 1:
                    // Шифрование
                    scanner.nextLine();
                    pathRead = UserChoiceScanner.getUserPathRead(scanner, "Введите путь к файлу для зашифровки: ");
                    keyDecrypt = UserChoiceScanner.getUserKey(scanner, "Введите ключ: ");
                    scanner.nextLine();
                    pathWrite = UserChoiceScanner.getUserPathWrite(scanner, "Введите путь для записи зашифровонного файла: ");

                    FileManager.writeFile(Cipher.encrypt(FileManager.readFile(pathRead, StandardCharsets.UTF_8), keyDecrypt),
                            pathWrite, false);
                    System.out.println("Текст успешно зашифрован и сохранён в " + pathWrite + "\n");
                    break;
                case 2:
                    scanner.nextLine();
                    pathRead = UserChoiceScanner.getUserPathRead(scanner, "Введите путь к файлу для расшифровки: ");
                    keyEncrypt = UserChoiceScanner.getUserKey(scanner, "Введите ключ: ");
                    scanner.nextLine();
                    pathWrite = UserChoiceScanner.getUserPathWrite(scanner, "Введите путь для записи расшифрованного файла: ");
                    //Расшифровка
                    FileManager.writeFile(Cipher.decrypt(FileManager.readFile(pathRead, StandardCharsets.UTF_8), keyEncrypt),
                            pathWrite, false);
                    System.out.println("Текст успешно расшифрован и сохранён в " + pathWrite + "\n");
                    break;
                case 3:
                    scanner.nextLine();
                    pathRead = UserChoiceScanner.getUserPathRead(scanner, "Введите путь к файлу для расшифровки: ");
                    pathWrite = UserChoiceScanner.getUserPathWrite(scanner, "Введите путь для записи вариаций текста: ");
                    //Грубая расшифровка. Записываем все варианты
                    System.out.print("Вы хотите записать варианты текста в один файл (да/нет): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("да")) {
                        aBoolean = false;
                    }
                    BruteForce.decryptByBruteForce(FileManager.readFile(pathRead, StandardCharsets.UTF_8),
                            Alphabet.CYRILLIC.getAlphabet(), pathWrite, aBoolean);
                    System.out.println("Метод успешно реализован \n");
                    break;
                case 4:
                    scanner.nextLine();
                    pathRead = UserChoiceScanner.getUserPathRead(scanner, "Введите путь к файлу для подбора ключа: ");
                    //Определяем наиболее вероятный ключ
                    System.out.println("Введите набор букв.\nДля более точного определения ключа, введите буквы через пробел\n(пример: \"о е а и н т с р в\"): ");
                    String s = scanner.nextLine();
                    StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
                    int autoKey = statisticalAnalyzer.findMostLikelyShift(FileManager.readFile(pathRead, StandardCharsets.UTF_8),
                            Alphabet.CYRILLIC.getAlphabet(), s);
                    System.out.println("Ваш ключ: " + autoKey + "\n");
                    break;
                case 0:
                    System.out.println("Спасибо за использование программы!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}
