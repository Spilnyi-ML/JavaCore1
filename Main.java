package homeWorkLesson2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            // Вариант 1:
        Scanner scanner = new Scanner(System.in);
        // Введите целое положительное число не меньше 1, кроме 4, если вам нужно протестировать
        // исключение MyArraySizeException:
        System.out.println("Введите число 4, которое определяет кол-во строк двумерного массива: ");
        int i = scanner.nextInt();
        System.out.println("Введите число 4, которое определяет кол-во столбцов двумерного массива: ");
        int j = scanner.nextInt();
        scanner.close();

        try {
            //Вариант 1:
            sizeArray(new String[i][j], new Integer[i][j]);
            //Вариант 2:
        //    sizeArray(new String[4][4], new Integer[4][4]);
            //используйте это, если вам нужно протестировать исключение MyArraySizeException:
        //    sizeArray(new String[5][4], new Integer[5][4]);
            }
        catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Исключение! Неверно задан размер массива!");
        }
        catch (MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Исключение! Неверно задан тип значения элемента массива!");
        }
        System.out.println("Программа работает дальше!");
    }

    private static int sizeArray(String[][] strArray, Integer[][] intArray) throws MyArraySizeException,
            MyArrayDataException {
        for (int n = 0; n < strArray.length; n++) {
            for (int m = 0; m < strArray[n].length; m++) {
                Random random = new Random();
                strArray[n][m] = String.valueOf(random.nextInt(10, 100));
                //используйте это, если вам нужно протестировать исключение MyArrayDataException:
        //           strArray[3][1] = "Hello World";
                System.out.println("[" + n + "][" + m + "]   " + strArray[n][m]);
            }
        }
        System.out.println("---------------------------------------------------------------------");

        if (strArray.length != 4 || strArray[0].length != 4)
            throw new MyArraySizeException("Размер массива не [4][4]. Размер массива : [" + strArray.length +
                    "][" + strArray[0].length + "]");
        System.out.println("Размер массива : [" + strArray.length +
                "][" + strArray[0].length + "]. Всё отлично!");
        System.out.println("---------------------------------------------------------------------");

        int summ = 0;
        int a = 0;
        int b = 0;
        try {
            for (int n = 0; n < strArray.length; n++) {
                for (int m = 0; m < strArray[n].length; m++) {
                    a = n;
                    b = m;
                    intArray[n][m] = Integer.parseInt(strArray[n][m]);
                    summ = intArray[n][m] + summ;
                }
            }
            System.out.println("Сумма всех значений двумерного массива равна <" + summ + ">");
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("Значение элемента [" + a + "][" + b + "] массива - не число! "
                                 + "Значение = " + strArray[a][b]);
        }
        System.out.println("---------------------------------------------------------------------");
        return summ;
    }
}