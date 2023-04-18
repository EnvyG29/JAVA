package dz1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;

public class dz1 {
    public static void main(String[] args) {
        Random ran = new Random();
        int[] array = new int[ran.nextInt(10) + 5];
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(89) + 10;
            System.out.print(array[i] + " ");
        }
        System.out.println();

//        int[] res1 = ex1();
//        ex2(array);
//        ex3();
//        ex4();
        ex5(array);
    }

    private static int[] ex1() {
        /*1. Написать метод, принимающий на вход два аргумента:
        len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue*/

        Scanner scanner = new Scanner(System.in);
        System.out.print("Len: ");
        int len = scanner.nextInt();
        System.out.print("initialValue: ");
        int initialValue = scanner.nextInt();
        scanner.close();
        int[] arr = new int[len];
        for (int item : arr) {
            item = initialValue;
            System.out.print(item + " ");
        }
        return arr;
    }

    private static void ex2(int[] arr) {
        /*2. Задать одномерный массив и найти в нем минимальный и максимальный элементы*/

        OptionalInt max0 = Arrays.stream(arr).max();
        int max = max0.getAsInt();
        OptionalInt min0 = Arrays.stream(arr).min();
        int min = min0.getAsInt();
        System.out.printf("min = %d, max = %d\n", min, max);
        /////////////////////////////////////// Вариант 2
        int minn = arr[0];
        int maxx = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minn > arr[i]) {
                minn = arr[i];
            }
            if (maxx < arr[i]) {
                maxx = arr[i];
            }
        }
        System.out.printf("min = %d, max = %d\n", minn, maxx);
    }

    private static void ex3() {
        /*3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
                и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
                Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];*/

        Random random = new Random();
        int len = random.nextInt(3) + 7;
        int[][] matrix = new int[len][len];
        int q = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][q--] = 1;
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d  ", matrix[i][j]);
            }
            System.out.println();
        }

    }

    private static void ex4() {
        /*4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
        "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        "Доброй ночи, <Имя>!", если время от 23:00 до 4:59*/

        String[] greeting = new String[]{"Доброе утро, %s!", "Добрый день, %s!", "Добрый вечер, %s!", "Доброй ночи, %s!"};
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        int n = 0;
        int hourNow = LocalDateTime.now().getHour();
        if (hourNow >= 12 && hourNow <= 16) {
            n = 1;
        } else if (hourNow >= 17 && hourNow <= 23) {
            n = 2;
        } else if (hourNow >= 0 && hourNow <= 3) {
            n = 3;
        }

        System.out.printf(greeting[n], name);
        System.out.println();
    }

    public static void ex5(int[]arr) {
        int n = 2;
        /*5.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
                Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        При каком n в какую сторону сдвиг может выбирать сами.*/

        int step = n % arr.length;
        int[] arrtemp = new int[arr.length];
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arrtemp, 0, arr.length);
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        if (n > 0) {
            for (int i = 0; i < arr.length; i++) {
                int iStep = i - step;
                if (iStep < 0) {
                    iStep = arr.length + iStep;
                }
                arr[i] = arrtemp[iStep];
                System.out.print(arr[i] + " ");
            }
        } else {
            int a = 0;
            for (int i = 0; i < arr.length; i++) {
                int iStep = i - step;
                if (iStep > arr.length - 1) {
                    iStep = a++;
                }
                arr[i] = arrtemp[iStep];
                System.out.print(arr[i] + " ");
            }
        }
    }
}