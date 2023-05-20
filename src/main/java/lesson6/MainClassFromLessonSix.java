package lesson6;

import java.util.*;

public class MainClassFromLessonSix {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,69, 11, 43, 3, 22, 76, 2, 1 ,2, 1 ,-3));
        hashSet.add(0);

        for (Object item : hashSet){
            System.out.print(item + " ");
        }
        System.out.println();

        LinkedHashSet lHashSet = new LinkedHashSet<>(Arrays.asList(1,2,3,4,5,6,7,69, 11, 43, 3, 22, 76, 2, 1 ,2, 1 ,-3));
        lHashSet.add(0);
        lHashSet.add(6);

        for (Object item: lHashSet) {
            System.out.print(item + " ");
        }


        int[] arr =  ex1_1();
        ex1_2(arr);



    }

    private static int[] ex1_1() {
        //1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.

        int[] array = new int[1000];

        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(25);
        }
        return array;
    }

    private static void ex1_2(int[] array) {
        //2. Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных значений в данном массиве и верните его в виде числа с плавающей запятой.
        //Для вычисления процента используйте формулу:
        //процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.оздайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.  Распечатайте содержимое данного множества.
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            set.add(num);
        }

        int lenSet = set.size();

        Double result = lenSet * 100.0 / array.length;
        System.out.println();
        System.out.println(result);
    }
}
