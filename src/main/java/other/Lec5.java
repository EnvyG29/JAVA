package other;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lec5 {
    public static void main(String[] args) {
        lec5();

    }

    private static void lec5() {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(null, "!null");
        System.out.println(db); // {null=!null, 1=один, 2=два}
        System.out.println(db.get(44));
        db.remove(null);
        System.out.println(db); // {1=один, 2=два}
        System.out.println(db.containsValue("один")); // true
        System.out.println(db.containsValue(1)); // false
        System.out.println(db.containsKey("один")); // false
        System.out.println(db.containsKey(1)); // true
        System.out.println(db.keySet());
        System.out.println(db.values());

        for (var item : db.entrySet()) {
            System.out.printf("%d, %s\n", item.getKey(), item.getValue());
        }
        TreeMap<Integer, String> newdb = new TreeMap<>();
        newdb.put(2, "22");
        System.out.println(newdb);
        newdb.put(1, "1");
        System.out.println(newdb);
        newdb.put(4, "4444");
        System.out.println(newdb);
        newdb.put(3, "333");
        System.out.println(newdb);
        System.out.println(newdb.get(2));
        newdb.remove(1);
//        System.out.println(newdb);
//        System.out.println(newdb.descendingMap());
//        System.out.println(newdb.tailMap(3));
//        System.out.println(newdb.headMap(4));
        System.out.println(newdb.lastEntry());
        System.out.println(newdb.firstEntry());
        System.out.println(newdb);


    }

}


