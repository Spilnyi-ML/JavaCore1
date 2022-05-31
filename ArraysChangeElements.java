package homeWorkLesson3;

import java.util.Scanner;

public class ArraysChangeElements {
    public static void main(String[] args) {
        String[] strArray = {"Hello", "5", "NEW", "83", "---"};
        info(strArray);
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Введите поочерёдно номера двух элементов массива, " +
                "значения которых хотите поменять местами:");
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        if (i >= 1 && j >= 1 && i <= 5 && j <= 5) {
            changes(strArray, i, j);
        } else System.out.println("Вы ввели номера несуществующих элементов массива!");
    }

    public static void info(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            int b = i+1;
            System.out.println("[" + b + "] элемент массива: " + strArray[i]);
        }
    }

    public static void changes(String[] strArray, int i, int j) {
            String s = strArray[i-1];
            strArray[i-1] = strArray[j-1];
            strArray[j-1] = s;

        System.out.println("----------------------------------------------------------------------------------------");
        for (int a = 0; a < strArray.length; a++) {
            System.out.println(strArray[a]);
        }
    }
}
