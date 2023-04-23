package dz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClassDz3 {
    public static void main(String[] args) {
        System.out.println("----1----");
        ex1();
        System.out.println("---2---");
        List<ArrayList<String>> CDB = CreateDataBooks();
        ex2(CDB, "Классика", "Ревизор");
        ex2(CDB, "IT", "Живи. Вкалывай. Сдохни");
        ex2(CDB, "Детектив", "Шерлок Холмс");
        ex2(CDB, "Ужасы", "Оно");
        ex2(CDB, "IT", "Кровь. Пот и Пиксели");
        System.out.println(CDB);
    }

    private static void ex1() {
        /**
         *  1. Создать список типа ArrayList<String>.
         * Поместить в него как строки, так и целые числа.
         * Пройти по списку, найти и удалить целые числа.
         * Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}
         */

        List<String> list = new ArrayList<>(Arrays.asList("Яблоко", "11", "13", "Апельсин", "Дыня", "17"));
        list.removeIf(s -> s.matches("\\d+"));
        for (String el :
                list) {
            System.out.println(el);
        }
    }


    private static void ex2(List<ArrayList<String>> data_base, String genre, String name) {
        /**
         * 2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
         * что на нулевой позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
         * Напишите метод для заполнения данной структуры(можно через консоль).
         * Пример:
         * "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
         * "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
         * "Детектив", "Десять негритят".
         * "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
         */
        ArrayList<String> li = new ArrayList<>(Collections.singletonList(genre));
        for (ArrayList<String> strings : data_base) {
            if (genre.equals(strings.get(0))) {
                strings.add(name);
                return;
            }
        }
        data_base.add(li);
        data_base.get(data_base.size()-1).add(name);
    }

    private static List<ArrayList<String>> CreateDataBooks() {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("Классика", "Преступление и наказание", "Война и мир", "Анна Каренина"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие"));
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("Детектив", "Десять негритят"));
        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал"));
        List<ArrayList<String>> dataBase = new ArrayList<>();
        dataBase.add(list1);
        dataBase.add(list2);
        dataBase.add(list3);
        dataBase.add(list4);
        System.out.println(dataBase);
        return dataBase;
    }
}
