package dz5;

import java.util.*;

public class MainClassDz5 {
    public static void main(String[] args) {
//        //        Map<String, ArrayList<String>> notePhone = ex1();
//        for (var item : notePhone.entrySet()) {
//            System.out.println(item);
//        }
//        //        ex2(notePhone);
        ex3();


    }

    private static Map<String, ArrayList<String>> ex1() {
        System.out.println("----01----");
        /**
         * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
         * Пусть дан список сотрудников:
         Иван Иванов
         Светлана Петрова
         Кристина Белова
         Анна Мусина
         Анна Крутова
         Иван Юрин
         Петр Лыков
         Павел Чернов
         Петр Чернышов
         Мария Федорова
         Марина Светлова
         Мария Савина
         Мария Рыкова
         Марина Лугова
         Анна Владимирова
         Иван Мечников
         Петр Петин
         Иван Ежов
         */
        Map<String, ArrayList<String>> note = Map.ofEntries(
                Map.entry("Иван Иванов", new ArrayList<>(List.of("+7 950 1234"))),
                Map.entry("Светлана Петрова", new ArrayList<>(Arrays.asList("+7 950 4321", "+7 950 2345"))),
                Map.entry("Кристина Белова", new ArrayList<>(List.of("+7 950 8775"))),
                Map.entry("Анна Мусина", new ArrayList<>(Arrays.asList("+7 950 3333", "+7 950 5555"))),
                Map.entry("Анна Крутова", new ArrayList<>(Arrays.asList("+7 950 4456", "+7 950 9855"))),
                Map.entry("Иван Юрин", new ArrayList<>(Arrays.asList("+7 950 9807", "+7 950 6879", "+7 950 0000"))),
                Map.entry("Петр Лыков", new ArrayList<>(Arrays.asList("+7 950 1212", "+7 950 8796"))),
                Map.entry("Павел Чернов", new ArrayList<>(List.of("+7 950 6665"))),
                Map.entry("Петр Чернышов", new ArrayList<>(List.of("+7 950 9753"))),
                Map.entry("Мария Федорова", new ArrayList<>(List.of("+7 950 1357"))),
                Map.entry("Марина Светлова", new ArrayList<>(List.of("+7 950 2468"))),
                Map.entry("Мария Савина", new ArrayList<>(List.of("+7 950 3579"))),
                Map.entry("Мария Рыкова", new ArrayList<>(List.of("+7 950 4680"))),
                Map.entry("Марина Лугова", new ArrayList<>(List.of("+7 950 1133"))),
                Map.entry("Анна Владимирова", new ArrayList<>(List.of("+7 950 6754"))),
                Map.entry("Иван Мечников", new ArrayList<>(Arrays.asList("+7 950 1277", "+7 950 1293"))),
                Map.entry("Петр Петин", new ArrayList<>(Arrays.asList("+7 950 8702", "+7 950 6543"))),
                Map.entry("Иван Ежов", new ArrayList<>(List.of("+7 950 4538")))
        );
        return note;
    }

    private static void ex2(Map<String, ArrayList<String>> note) {
        System.out.println("\n----02----");
        /**
         Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
         Отсортировать по убыванию популярности.
         */
        Map<String, Integer> sor = new HashMap<>();
        for (var item : note.keySet()) {
            String item2 = item.split(" ")[0];
            if (sor.containsKey(item2)) {
                sor.put(item2, sor.get(item2) + 1);
            } else {
                sor.put(item2, 1);
            }
        }
        System.out.println(sor);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sor.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list);
    }

    private static void ex3() {
        System.out.println("\n----03----");
        /**
         *  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
         */
        turnQ(0);
    }

    static int len = 5;
    static int num = 1;
    static int[][] place = new int[len][len];

    private static void turnQ(int row) {
        if (row == place.length) {
            System.out.println();
            printPlace();
            return;
        }
        for (int j = 0; j < place.length; j++) {
            if (checkQ(row, j)) {
                place[row][j] = 1;
                turnQ(row + 1);
            }
            place[row][j] = 0;
        }
    }

    private static boolean checkQ(int row, int column) {
        for (int k = 0; k < place.length; k++) {
            if (place[row][k] == 1 || place[k][column] == 1) {
                return false;
            }
            int q = row - column + k;
            if (q >= 0 && q < place.length) {
                if (place[q][k] == 1) {
                    return false;
                }
            }
            q = row + column - k;
            if (q >= 0 && q < place.length) {
                if (place[q][k] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printPlace() {
        System.out.println("№" + num);
        num++;
        for (int[] i : place) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}