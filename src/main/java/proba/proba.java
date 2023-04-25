package proba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class proba {
    public static void main(String[] args) {
        ex3();


    }
    private static void ex3() {

        // При решении задачи исхожу из того, что при появлении в ассортименте какой-то новой книги,
        // данная книга естественно имеет название, и принадлежит какому-то определенному жанру литературы.
        // Соответственно эти данные - это все что мне нужно.

        // Ну и допускаю, что на данный момент у нас в ассортименте имеются книги следующих жанров:
        // Количество жанров может увеличиться, при увеличении ассортимента.
        String[] genres = {"Классика", "Научная фантастика", "Детективы", "Фантастика"};

        // И в каждом из жанров на данный момент имеются следующие книги
        // (при появлении в ассортименте новых книг данные о них будут добавлены в соответствующие массивы):
        String[] classic = {"Преступление и наказание", "Война и мир", "Анна Каренина"};
        String[] scienceFiction = {"Солярис", "Ночной дозор", "Братья Стругацкие"};
        String[] detective = {"Десять негритят"};
        String[] fantastic = {"Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал"};

        // Все существующие массивы с данными имеющимися у меня преобразую в списки для удобства оперирования в дальнейшем.

        // классика:
        List<String> listClassic = new ArrayList<>();
        listClassic.addAll(Arrays.asList(classic));
        listClassic.add(0, "Классика");

        // научная фантастика:
        List<String> listScienceFiction = new ArrayList<>();
        listScienceFiction.addAll(Arrays.asList(scienceFiction));
        listScienceFiction.add(0, "Научная фантастика");

        // детективы:
        List<String> listDetective = new ArrayList<>();
        listDetective.addAll(Arrays.asList(detective));
        listDetective.add(0, "Детективы");

        // фантастика:
        List<String> listFantastic = new ArrayList<>();
        listFantastic.addAll(Arrays.asList(fantastic));
        listFantastic.add(0, "Фантастика");

        // список жанров литературы:
        List<String> listGenres = new ArrayList<>();
        listGenres.addAll(Arrays.asList(genres));


        // Создаю сам каталог литературы, которая уже есть в ассортименте магазина:
        // и вывожу его на печать:
        System.out.println("Каталог литературы уже существующего ассортимента:");
        System.out.println();
        List<ArrayList<String>> catalog = new ArrayList<>();
        List<String> tempArrayList = new ArrayList<>();

        for (String tempGenre : listGenres) {
            if (tempGenre.equals("Классика")) {
                tempArrayList = listClassic;
            }
            if (tempGenre.equals("Научная фантастика")) {
                tempArrayList = listScienceFiction;
            }
            if (tempGenre.equals("Детективы")) {
                tempArrayList = listDetective;
            }
            if (tempGenre.equals("Фантастика")) {
                tempArrayList = listFantastic;
            }
            catalog.add((ArrayList<String>) tempArrayList);
            String stringArrayList = String.join(", ", tempArrayList);
            System.out.println(stringArrayList);
        }
        System.out.println();

        // ну и собственно вот так бы выглядело добавление новой книги в каталог:
        System.out.println("Добавляем новую книгу в каталог книжного магазина и выводим новый каталог на печать.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги:");
        String bookTitle = scanner.nextLine();
        System.out.println("Определите к какому жанру литературы принадлежит данная книга:");
        String bookGenre = scanner.nextLine();
        List<String> listNewGenre = new ArrayList<>();
        for (int i = 0; i < listGenres.size(); i++) {
            if(bookGenre.equals("Классика")){
                listClassic.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Научная фантастика")){
                listScienceFiction.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Детективы")){
                listDetective.add(bookTitle);
                break;
            }
            if(bookGenre.equals("Фантастика")){
                listFantastic.add(bookTitle);
                break;
            }
            if(!listGenres.contains(bookGenre)){
                listGenres.add("Новый жанр");
                listNewGenre.add(bookGenre);
                listNewGenre.add(bookTitle);
                break;
            }
        }

        // Новый каталог, после добавления новой книги:
        System.out.println();
        System.out.println("Обновленный каталог книжного магазина:");
        System.out.println();
        for (int i = 0; i < listGenres.size(); i++) {
            String tempGenre = listGenres.get(i);
            if (tempGenre.equals("Классика")) {
                tempArrayList = listClassic;
            }
            if (tempGenre.equals("Научная фантастика")) {
                tempArrayList = listScienceFiction;
            }
            if (tempGenre.equals("Детективы")) {
                tempArrayList = listDetective;
            }
            if (tempGenre.equals("Фантастика")) {
                tempArrayList = listFantastic;
            }
            if (tempGenre.equals("Новый жанр")) {
                tempArrayList = listNewGenre;
            }
            catalog.add((ArrayList<String>) tempArrayList);
            String stringArrayList = String.join(", ", tempArrayList);
            System.out.println(stringArrayList);
        }
    }
}
