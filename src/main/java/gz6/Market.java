package gz6;

import java.util.*;

public class Market {
    public static void main(String[] args) {
        Set notebooksSet = Notebooks();
        System.out.println("В наличие ");
        for (var i : notebooksSet) {
            {
                System.out.println(i);
            }
        }

        findParameter(notebooksSet);
    }

    private static void findParameter(Set<Notebooks> notebooksSet) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nВыберите номера критерий поиска через пробел: ");

        int inputMin;
        ArrayList<Integer> criteria = new ArrayList<>();
        ArrayList<String> inputStr = new ArrayList<>();
        Map<Integer, ArrayList<String>> criteriaLetter = new HashMap<>();
        ArrayList<String> nameNB = new ArrayList<>(Arrays.asList("LG", "Asus", "Apple", "Samsung", "MSI"));
        criteriaLetter.put(1, nameNB);
        ArrayList<String> cpuNB = new ArrayList<>(Arrays.asList("AMD", "Intel", "M1", "M2"));
        criteriaLetter.put(2, cpuNB);
        ArrayList<String> osNB = new ArrayList<>(Arrays.asList("Windows", "MacOS", "Linux", "BIOS"));
        criteriaLetter.put(3, osNB);
        Map<Integer, Integer> criteriaDigit = new HashMap<>();
        criteriaDigit.put(4, 0);
        criteriaDigit.put(5, 0);
        criteriaDigit.put(6, 0);
        String[] name = new String[]{"брендов", "процессоров", "OS", "HDD", "RAM", "цен"};

        System.out.println("1 - бренд");
        System.out.println("2 - процессор");
        System.out.println("3 - OS");
        System.out.println("4 - HDD");
        System.out.println("5 - RAM");
        System.out.println("6 - цена");
        System.out.print("-> ");

        for (String item : scanner.nextLine().split(" ")) {
            criteria.add(Integer.parseInt(item));
        }
        for (int i : criteria) {

            if (i <= 3) {
                System.out.printf("Введите названия %s через пробел ", name[i - 1]);
                for (String item : scanner.nextLine().split(" ")) {
                    inputStr.add(item);
                }
                criteriaLetter.put(i, inputStr);
            } else {
                System.out.printf("Введите минимальный порог %s ", name[i - 1]);
                inputMin = Integer.parseInt(scanner.nextLine());
                criteriaDigit.put(i, inputMin);
            }

        }

        System.out.println("\nРезультат поиска ");
        for (Notebooks notebook : notebooksSet) {
            if (criteriaLetter.get(1).contains(notebook.getName()) && criteriaLetter.get(2).contains(notebook.getCpu()) && criteriaLetter.get(3).contains(notebook.getOs()) &&
                    criteriaDigit.get(4) <= notebook.getHdd() && criteriaDigit.get(5) <= notebook.getRam() && criteriaDigit.get(6) <= notebook.getPrice()) {
                System.out.println(notebook);
            }
        }
    }

    private static Set Notebooks() {
        Notebooks nbLG512 = new Notebooks("LG", "Intel", "BIOS", 512, 8, 50_000);
        Notebooks nbLG1024 = new Notebooks("LG", "Intel", "BIOS", 1024, 16, 70_000);
        Notebooks nbLG1024W = new Notebooks("LG", "Intel", "Windows", 512, 16, 75_000);
        Notebooks nbLG512L = new Notebooks("LG", "Intel", "Linux", 512, 8, 55_000);
        Notebooks nbApplePlus = new Notebooks("Apple", "M2", "MacOS", 1024, 16, 150_000);
        Notebooks nbApplePro = new Notebooks("Apple", "M2", "MacOS", 2048, 64, 180_000);
        Notebooks nbApple = new Notebooks("Apple", "M1", "MacOS", 512, 16, 120_000);
        Notebooks nbAsus512W = new Notebooks("Asus", "Intel", "Windows", 512, 16, 80_000);
        Notebooks nbAsus512 = new Notebooks("Asus", "Intel", "BIOS", 512, 16, 55_000);
        Notebooks nbAsus1024 = new Notebooks("Asus", "Intel", "BIOS", 512, 8, 65_000);
        Notebooks nbAsus1024L = new Notebooks("Asus", "Intel", "Linux", 1024, 16, 70_000);
        Notebooks nbAsus2048 = new Notebooks("Asus", "Intel", "BIOS", 2048, 64, 80_000);
        Notebooks nbAsus2048W = new Notebooks("Asus", "AMD", "Windows", 2048, 64, 105_000);
        Notebooks nbSamsung512 = new Notebooks("Samsung", "AMD", "BIOS", 512, 16, 60_000);
        Notebooks nbSamsung1024L = new Notebooks("Samsung", "AMD", "Linux", 1024, 32, 80_000);
        Notebooks nbSamsung1024 = new Notebooks("Samsung", "AMD", "BIOS", 1024, 16, 75_000);
        Notebooks nbSamsung512W = new Notebooks("Samsung", "Intel", "Windows", 512, 16, 70_000);
        Notebooks nbMSI1024 = new Notebooks("MSI", "AMD", "BIOS", 1024, 32, 100_000);
        Notebooks nbMSI2048 = new Notebooks("MSI", "AMD", "BIOS", 2048, 64, 130_000);
        Notebooks nbMSI1024W = new Notebooks("MSI", "AMD", "Windows", 1024, 32, 125_000);
        Notebooks nbMSI2048W = new Notebooks("MSI", "AMD", "Windows", 2048, 64, 155_000);

        Set<Notebooks> notebooksSet = new HashSet<>();
        notebooksSet.add(nbLG512);
        notebooksSet.add(nbLG1024);
        notebooksSet.add(nbLG1024W);
        notebooksSet.add(nbLG512L);
        notebooksSet.add(nbApplePlus);
        notebooksSet.add(nbApplePro);
        notebooksSet.add(nbApple);
        notebooksSet.add(nbAsus512W);
        notebooksSet.add(nbAsus512);
        notebooksSet.add(nbAsus1024);
        notebooksSet.add(nbAsus1024L);
        notebooksSet.add(nbAsus2048);
        notebooksSet.add(nbAsus2048W);
        notebooksSet.add(nbSamsung512);
        notebooksSet.add(nbSamsung1024L);
        notebooksSet.add(nbSamsung1024);
        notebooksSet.add(nbSamsung512W);
        notebooksSet.add(nbMSI1024);
        notebooksSet.add(nbMSI2048);
        notebooksSet.add(nbMSI1024W);
        notebooksSet.add(nbMSI2048W);
        return notebooksSet;
    }

}
