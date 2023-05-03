package lesson5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MainClassFrommLessonFifth {
    public static void main(String[] args) {
//        ex1();
        int i = ex2("MMXXII");
        String i2 = ex3(2022);
        System.out.println(i);
        System.out.println(i2);

    }

    private static void ex1() {
        /**Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
         123456 Иванов
         321456 Васильев
         234561 Петрова
         234432 Иванов
         654321 Петрова
         345678 Иванов
         Вывести данные по сотрудникам с фамилией Иванов.
         */
        Map<String, String> employeeMap = new HashMap<>(20);
        employeeMap.put("1234", "Иванов");
        employeeMap.put("1224", "Петров");
        employeeMap.put("5534", "Романцев");
        employeeMap.put("2234", "Зубов");

        for (Map.Entry<String, String> enpty : employeeMap.entrySet()) {
            System.out.printf("%s\t->\t%s%n", enpty.getKey(), enpty.getValue());
        }

        for (String key : employeeMap.keySet()
        ) {
            System.out.printf("%s\t->\t%s%n", key, employeeMap.get(key));
        }

        employeeMap.forEach((key, value) -> {
            System.out.printf("%s\t->\t%s%n", key, value);
        });

        // создание неизменяемой map
        Map<Integer, String> testMap = Map.of(
                12, "A",
                43, "b",
                22, "c"
        );

        // создание Map размером больше 10
        Map<Integer, Integer> testMap2 = Map.ofEntries(
                Map.entry(234, 232),
                Map.entry(24, 222),
                Map.entry(2371, 2552),
                Map.entry(2377, 2325)
        );
    }

    private static Integer ex2(String str) {
        /**
         * Написать метод, который переведет число из римского формата записи в арабский.
         * Например, MMXXII = 2022
         */

        Map<Character, Integer> rumDict = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        StringBuilder romanNum = new StringBuilder(str.trim()).reverse();
        int result = 0;
        int prevNum = -1;

        for (Character romanChar : romanNum.toString().toCharArray()) {
            int curretNum = rumDict.get(romanChar);
            if (curretNum < prevNum) {
                curretNum *= -1;
            }
            result += curretNum;
            prevNum = curretNum;
        }
        return result;
    }

    private static String ex3(int number) {
        Map<Integer, String> rumDict = Map.ofEntries(
                Map.entry(1, "I"),
                Map.entry(10, "X"),
                Map.entry(5, "V"),
                Map.entry(50, "L"),
                Map.entry(100, "C"),
                Map.entry(500, "D"),
                Map.entry(1000, "M"),
                Map.entry(4, "IV"),
                Map.entry(9, "IX"),
                Map.entry(40, "XL"),
                Map.entry(90, "XC")
        );

        Map<Integer, String> arabicToRoman= new TreeMap<>(Comparator.reverseOrder());
        arabicToRoman.putAll(rumDict);

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, String> entry: arabicToRoman.entrySet()) {
            int arabic = entry.getKey();
            String roman = entry.getValue();
            while (number >= arabic){
                result.append(roman);
                number -= arabic;
            }
        }
        return result.toString();
    }
}