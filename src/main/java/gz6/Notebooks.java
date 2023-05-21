package gz6;

import java.util.Objects;

public class Notebooks {

    String name;
    String cpu;
    int ram;
    String os;
    int hdd;
    int price;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public int getHdd() {
        return hdd;
    }

    public Notebooks(String name, String cpu, String os, int hdd, int ram, int price) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.os = os;
        this.hdd = hdd;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(name).append(" ").append(cpu).append(" ").append(os).append(" ").append(hdd).append("GB ")
                .append(ram).append("GB ₽").append(price);
        return strb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpu, os, hdd, ram, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Notebooks)) {
            return false;
        }
        Notebooks temp = (Notebooks) obj;
        return temp.name.equals(this.name) && temp.cpu.equals(this.cpu) && temp.os.equals(this.os)
                && temp.hdd == this.hdd && temp.ram == this.ram && temp.price == this.price;
    }

}
