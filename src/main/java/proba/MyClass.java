package proba;

public class MyClass {
        int id;
        int number;
        String name;


    public String to_String() {
        return String.format("id: %d, name: %s%d", id, name, number);
    }
}
