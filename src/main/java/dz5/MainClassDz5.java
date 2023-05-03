package dz5;

import java.util.*;

public class MainClassDz5 {
    public static void main(String[] args) {
        System.out.println("----01----");
        Map<String, ArrayList<String>> notePhone = ex1();
        for (var item : notePhone.entrySet()) {
            System.out.println(item);
        }
        System.out.println("\n----02----");
        ex2(notePhone);
        System.out.println("\n----03----");
        ex3();


    }

    private static Map<String, ArrayList<String>> ex1() {
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
        /**
         *  На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
         */
        int len = 4;


        int nextRow = 1;
        for (int i = 0; i < len; i++) {
            int[][] place = new int[len][len];
            place[0][i] = 1;
            turnQueen(place, len, nextRow);
        }
    }

    public static void turnQueen(int[][] place, int l, int next) {
        if (next == l) {
            printPlace(place);
            return;
        }
        for (int i = 0; i < l; i++) {
            place[next][i] = 1;
            if (!checkAll(place, l)) {
                place[next][i] = 0;
            } else if (checkAll(place, l)) {
                turnQueen(place, l, next + 1);
            }
        }
    }

    public static boolean checkAll(int[][] arr, int l) {
        if (checkRow(arr, l) &&
                checkColumn(arr, l) &&
                checkDiagonalL(arr, l) &&
                checkDiagonalR(arr, l)) {
            return true;
        }
        return false;
    }

    public static boolean checkRow(int[][] arr, int l) {
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = 0; j < l; j++) {
                sum += arr[i][j];
                if (sum > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkColumn(int[][] arr, int l) {
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = 0; j < l; j++) {
                sum += arr[j][i];
                if (sum > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkDiagonalL(int[][] arr, int l) {
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += arr[i][i];
            if (sum > 1) {
                return false;
            }
        }
        for (int j = 1; j < l - 1; j++) {
            sum = 0;
            for (int i = 0; i < l; i++) {
                if (i + j < l) {
                    sum += arr[i][i + j];
                    if (sum > 1) {
                        return false;
                    }
                }
            }
            sum = 0;
            for (int i = 0; i < l; i++) {
                if (i + j < l) {
                    sum += arr[i + j][i];
                    if (sum > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkDiagonalR(int[][] arr, int l) {
        int sum = 0;
        for (int i = 0; i < l; i++) {
            sum += arr[i][l - i - 1];
            if (sum > 1) {
                return false;
            }
        }

        for (int j = 2; j < l; j++) {
            sum = 0;
            int n = 0;
            for (int i = l - j; i >= 0; i--) {
                sum += arr[i][n];
                if (sum > 1) {
                    return false;
                }
                n++;
            }
        }

        for (int j = 1; j < l - 1; j++) {
            sum = 0;
            int m = j;
            for (int i = l - 1; i > 0; i--) {
                if (m < l) {
                    sum += arr[i][m];
                }
                if (sum > 1) {
                    return false;
                }
                m++;
            }
        }
        return true;
    }

    public static void printPlace(int[][] arr) {
        int index = 1;
        System.out.print("   _");
        for (int i = 1; i <= arr.length; i++) {
            if (i < 10) System.out.print("0");
            System.out.print(i + "_");
        }
        System.out.println();
        for (int[] item : arr) {
            if (index < 10) System.out.print("0");
            System.out.print(index + "| ");
            index += 1;
            for (int item2 : item) {
                if (item2 < 10) System.out.print(" ");
                System.out.print(item2 + " ");
            }
            System.out.println();
        }
    }
}
