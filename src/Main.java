//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder,
// создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\kaval\\IdeaProjects\\Task2\\src\\data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder result = new StringBuilder();
                String[] parts = line.split(",");
                for (String part : parts) {
                    String[] kv = part.split(":");
                    if (kv[0].equals("{\"фамилия\"")) {
                        result.append(("Студент "))
                                .append(kv[1].replaceAll("\"", ""))
                                .append(" ");
                    } else if (kv[0].equals("\"оценка\"")) {
                        result.append(("получил "))
                                .append(kv[1].replaceAll("\"", ""))
                                .append(" ");
                    } else if (kv[0].equals("\"предмет\"")) {
                        result.append(("по предмету "))
                                .append(kv[1].replaceAll("\"","").replaceAll("}", ""))
                                .append(".");

                    }
                }
                System.out.println((result.toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}