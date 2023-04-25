package lesson4;

import java.util.*;
public class MainClassFromLessonFour {
     public static void main(String[] args) {
         /**
          * 1. Принимает от пользователя строку вида
          * 2. text~num
          * 3. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
          * 4. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
          * 4. Продумать систему добавления элементов на индексы, превышающие размер
          * 5. Добавить проверки ввода
          * 6. Добавить еще команд на выбор
          */
         ex1();
     }
     private static void ex1(){
         Scanner in = new Scanner(System.in);
         LinkedList<String> wordsList = new LinkedList<>();
         Collections.addAll(wordsList, "apple", "orange", "banana", "tomato","strawberry","melon");

         while (true){
             System.out.println();
             System.out.print("Введите строку: ");
             String inputString = in.nextLine();

             if (( inputString.trim().length()==0) || (inputString.isBlank())){ // trim удаляет начальные и конечные пробельные символы. isBlank вернет true если строка пустая или содержит только пробельные символы
                 System.out.println("cтрока не должна быть пустой" );
                 continue;
             }

             if (inputString.equalsIgnoreCase("стоп-фраза")){
                 break;
             }
             if (inputString.equalsIgnoreCase("print~all")){
                 printAllNotNullValue(wordsList);
                 continue;
             }
             if (!inputString.contains("~")){
                 System.out.println("Строка не содержит тильду");
                 continue;
             }

             String[] parts = "\\~".split(inputString);

             if (parts.length != 2){
                 System.out.println("строка введена не верно");
                 continue;
             }
             String word = parts[0];
             int num = 0;

             try {
                 num = Integer.parseInt(parts[1]);
             } catch (NumberFormatException e) {
                 System.out.println("строка не содержит числа");
                 continue;
             }

             if (num < 1){
                 System.out.println("Введите число больше 1");
                 continue;
             }

             if (word.equalsIgnoreCase("print")){
                 if (!isNumberInRange(num, wordsList.size()) || valueIsNull(wordsList, num)){
                     System.out.println("указаного числа не существует");
                 } else {
                     System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num-1));
                     wordsList.remove(num -1 );
                 }
             } else if (isNumberInRange(num, wordsList.size())){
                 String oldWord = wordsList.get(num-1);

                 if (valueIsNull(wordsList, num)){
                     printAddMessage(word,num);
                 } else {
                     printSetMessage(word, num, oldWord);
                 }
                 wordsList.set(num-1, word);
             } else {
                 int nullCount = num - wordsList.size() -1;
                 addNulls(wordsList, nullCount);
                 wordsList.add(word);
                 printAddMessage(word, num);
             }

         }
     }

     private static void addNulls(LinkedList<String> wordsList, int count){
         for (int i = 0; i < count; i++) {
             wordsList.add(null);
         }
     }

     private static void printAllNotNullValue(LinkedList<String> wordsList){
         for (int i = 0; i < wordsList.size(); i++) {
             if (wordsList.get(i) != null){
                 System.out.printf("%d) %s%n", i+1, wordsList.get(i));
             }
         }

     }

     private static boolean isNumberInRange(int num, int size){
         return num >= 1 && num <= size;
     }

     private static boolean valueIsNull(LinkedList<String> wordsList, int num){
         return wordsList.get(num -1) == null;
     }

     private static void printSetMessage(String word, int num, String oldWord){
         System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
     }

    private static void printAddMessage(String word, int num){
        System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
    }

}
