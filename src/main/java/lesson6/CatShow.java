package lesson6;

public class CatShow extends Cat {
    int place;
    String category;

    public CatShow(int age, String name, String breed, boolean isMale, int place, String category) {
        super(age, name, breed, isMale);
        this.place = place;
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString() + " " + category;
    }
}
