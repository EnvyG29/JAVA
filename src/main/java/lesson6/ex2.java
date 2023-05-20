package lesson6;

import java.util.HashSet;
import java.util.Set;

public class ex2 {
    public static void main(String[] args) {
        Cat cat = new Cat(2, "Вася","перситская", true);

        System.out.println(cat.toString());

        Cat cat1 = new Cat(5, "Маша", "перситская",false);

        System.out.println(cat1.toString());

        Cat cat2 = new Cat(2, "Вася", "перситская", true);

        CatVet cat4 = new CatVet(2, "Виктор", "Перс", true, "blanc", false);

        CatShow cat5 = new CatShow(2, "Йод", "Перс", true, 13, "High jump");

        System.out.println(cat == cat1);
        System.out.println(cat.equals(cat1));
        System.out.println(cat == cat2);


        Set<Cat> cats = new HashSet<>();
        cats.add(cat);
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat4);
        cats.add(cat5);

        System.out.println(cats);
    }
}
