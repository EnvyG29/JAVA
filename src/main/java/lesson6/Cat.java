package lesson6;

import java.util.Objects;

public class Cat {
    int age;
    String name;
    String breed;
    boolean isMale;

    public Cat(int age, String name, String breed, boolean isMale) {
        this.age = age;
        this.name = name;
        this.breed = breed;
        this.isMale = isMale;
    }


    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(name).append(" ").append(age);
        return strb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, breed, isMale);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Cat)){
            return false;
        }
        Cat temp = (Cat) obj;
        return temp.age == this.age && temp.isMale == this.isMale && temp.breed.equals(this.breed) && temp.name.equals(this.name);
    }
}
