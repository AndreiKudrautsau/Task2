//Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

public class Task1 {
    public static void main(String[] args) {
        String s = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String [] strings = s.replace(",", "")
                .replace("{", "")
                .replace("}", "")
                .split(" ");
        StringBuilder bl = new StringBuilder();
        bl.append(strings[0] + " ")
                .append(strings[1] + " ")
                .append(strings[2]);
        System.out.print(bl);
    }

}