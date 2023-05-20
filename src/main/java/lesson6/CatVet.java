package lesson6;

public class CatVet extends Cat {
    String medHistory;
    boolean isSterilized;

    public CatVet(int age, String name, String breed, boolean isMale, String medHistory,boolean isSterilized) {
        super(age, name, breed, isMale);
        this.medHistory = medHistory;
        this.isSterilized = isSterilized;
    }

    @Override
    public String toString() {
        return super.toString() + " " + medHistory;
    }
}
