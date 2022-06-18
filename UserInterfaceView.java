package homeWorkLesson8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);
        String currentAnswer = "";

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            while (!currentAnswer.equals("1") & !currentAnswer.equals("2") & !
                    currentAnswer.equals("5") & !currentAnswer.equals("0")) {
                System.out.println("Введите 1 для получения погоды на сегодня; " +
                        "Введите 2 для получения погоды из Базы Данных; " +
                        "Введите 5 для прогноза на 5 дней; " +
                        "Введите 0 для выхода");
                currentAnswer = scanner.nextLine();
                if (!currentAnswer.equals("1") & !currentAnswer.equals("2") &
                        !currentAnswer.equals("5") & !currentAnswer.equals("0")) {
                    System.out.println("Вы ввели некорректное значение!");
                }
            }

            String command = currentAnswer;

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("При получении погоды произошла ошибка. Попробуйте позже.");
            }
              break;
        }
    }
}