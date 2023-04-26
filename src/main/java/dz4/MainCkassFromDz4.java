package dz4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MainCkassFromDz4 {
    public static void main(String[] args) {
        LinkedList<String> str = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>(Arrays.asList("first", "второй", "3", "|","четвертый", "fifth", "6"));

        System.out.println("---1---");
        ex1(str);

        System.out.println("---2---");
        System.out.println(list);
        System.out.println(ex2(list));
    }

    private static void ex1(LinkedList<String> arr) {
        /**
         * 1.
         * Реализовать консольное приложение, которое:
         * Принимает от пользователя и “запоминает” строки.
         * Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
         * Если введено revert, удаляет предыдущую введенную строку из памяти.
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку или команду: ");

        while (true){
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("print")){
                print(arr);
                continue;
            }
            if (input.equalsIgnoreCase("revert")){
                arr.removeFirst();
                System.out.println("Предыдущая строка удалена");
                continue;
            }
            if (input.equalsIgnoreCase("stop")){
                print(arr);
                System.out.println("Приложение остановлено");
                return;
            }
            arr.addFirst(input);
            System.out.println("Введите новую стоку");
        }
    }

    private static void print(LinkedList<String> list){
        for (String str: list) {
            System.out.println(str);
        }
    }

    private static LinkedList<String> ex2(LinkedList<String> arr) {
        /**
         * 2.
         * Пусть дан LinkedList с несколькими элементами.
         * Реализуйте метод, который вернет “перевернутый” список.
         */
        for (int i = 1; i < arr.size(); i++) {
            arr.addFirst(arr.get(i));
            arr.remove(i+1);
        }
        return arr;
    }
}
