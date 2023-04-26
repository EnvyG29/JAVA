package lesson3;

import java.util.*;

public class MainClassFromLessonThree {
    public static void main(String[] args) {
        ex1();
        ArrayList<String> wq = ex2();
        ex2z2(wq);

    }

    private static void ex1() {

        /*Заполнить список десятью случайными числами.
                Отсортировать список методом sort() и вывести его на экран.*/

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }

        Collections.sort(list, Comparator.naturalOrder());
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        System.out.println("\n\n");
    }

    private static ArrayList<String> ex2() {
        /*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
          Вывести название каждой планеты и количество его повторений в списке.*/
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        List<String> planets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Random j = new Random();
            planets.add(planetsNamesStringArray[j.nextInt(planetsNamesStringArray.length)]);
        }
        System.out.println(planets);
        for (String plan : planetsNamesStringArray) {
            int result = Collections.frequency(planets, plan);
            if (result > 0) {
                System.out.println(plan + ": " + result);
            }
        }
        return (ArrayList<String>) planets;
    }

    private static void ex2z2(ArrayList<String> planets) {
        /*Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.*/
        List<String> unic = new ArrayList<>();
        for (String p : planets) {
            if (!unic.contains(p)) {
                unic.add(p);
            }
        }
        System.out.println(unic);

        Collections.sort(planets);
        int i = 1;
        while (i < planets.size()){
            if (planets.get(i).equals(planets.get(i - 1))) {
                planets.remove(i);
            }else {
                i++;
            }
        }
        System.out.println(planets);
    }
}
