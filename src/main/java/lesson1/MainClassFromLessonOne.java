package lesson1;

import java.util.Scanner;
import java.util.Arrays;

public class MainClassFromLessonOne {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();

    }

    private static void ex1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");
        System.out.printf("Привет %s!%n", name);
    }



    //                Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
    public static void ex2() {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1};
        int count = 0;
        int maxValue = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            } else {
                if (count > maxValue) {
                    maxValue = 0;
                    count = 0;

                }
            }
        }
        if (count > maxValue) maxValue = count;
        System.out.println(maxValue);
    }

    //    Дан массив nums = [3,2,2,3] и число val = 3.
//    Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//    Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
    private static void ex3() {
        int[] num = new int[]{3, 2, 2, 3, 1, 1, 1};
        int val = 3;
        int temp = 0;
        for (int j = 0; j < num.length - 1; j++)
            for (int i = 0; i < num.length - 1; i++) {
                if (num[i] == val) {
                    temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;
                }
            }
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    //    Во фразе  переставить слова в обратном порядке.
    private static void ex4() {
        String str = "Добро пожаловать на курс по Java";
        String[] words = str.split(" ");
        int len = words.length;
        String temp;
        for (int i = 0; i < len / 2; i++) {
            temp = words[i];
            words[i] = words[len - 1 - i];
            words[len - 1 - i] = temp;
        }
        String str_ = String.join(" ", words);
        System.out.println(str_);
    }

    private static void ex5() {
    }
}



