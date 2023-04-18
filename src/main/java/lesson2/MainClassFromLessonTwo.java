package lesson2;

import dz1.dz1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MainClassFromLessonTwo {
    public static void main(String[] args) {
        System.out.println(ex1(6));
        System.out.println(ex2("aaaabbbcddcccbdd"));
        System.out.println(ex3("А роза упала на лапу азора"));
//        System.out.println(ex4());
        ex5("C:\\Users\\Я\\IdeaProjects\\java-practic20230413");

    }

    private static String ex1(int n) {
        /*Дано четное число N (>0) и символы c1 и c2.
                Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.*/
//        String result = "";
//        for (int i = 0; i < n; i++) {
//            if (i %2 ==0){
//                result+= "A";
//            }
//            if (i%2 == 1){
//                result+= "B";
//            }
//        }
//        return result;
        ///////////////////////////
        StringBuilder result2 = new StringBuilder();
        char a = 'A';
        char b = 'B';
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result2.append(a);
            }
            if (i % 2 == 1) {
                result2.append(b);
            }
        }
        return result2.toString();
    }

    private static String ex2(String str) {
        /*Напишите метод, который сжимает строку.
        Пример: вход aaaabbbcdd.*/
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(i)) {
                count++;
                if (i == str.length() - 1) {
                    result.append(str.charAt(i));
                    if (count != 1) {
                        result.append(count);
                    }
                }
            } else {
                result.append(str.charAt(i - 1));
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
                if (i == str.length() - 1) {
                    result.append(str.charAt(i));
                }
            }
        }
        return result.toString();
    }

    private static boolean ex3(String str) {
        /*Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).*/
        str = str.toLowerCase().replace(" ", "").replace("-", "");
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != (str.charAt(str.length() - 1 - i))) {
                return false;
            }
        }
        return true;
    }


    private static String ex4() {
        /*Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.*/
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            str.append("TEST\n");
        }
        return str.toString();
    }

    public static void saveFileToStr() {


    }

    private static void ex5(String pathDir) {
        File file = new File(pathDir);
        if (!(file.exists() || file.isDirectory())) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String filename : file.list()) {
            sb.append(filename).append(System.lineSeparator());
        }
        System.out.println(sb);

        try (PrintWriter pw = new PrintWriter("src/main/resources/files/fileNames.txt");) {
            pw.print(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
