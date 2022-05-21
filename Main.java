package homeWorkLesson1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Team[] team = {
                new Team("Ivan", "Petrov", random.nextInt(20, 40),
                        random.nextFloat(5.5f, 10.7f), random.nextFloat(350f, 400f)),
                new Team("Petr", "Kireev", random.nextInt(20, 40),
                        random.nextFloat(5.5f, 10.7f), random.nextFloat(350f, 400f)),
                new Team("Anna", "Lukmazova", random.nextInt(20, 40),
                        random.nextFloat(5.5f, 10.7f), random.nextFloat(300f, 350f)),
                new Team("Larisa", "Fedorova", random.nextInt(20, 40),
                        random.nextFloat(5.5f, 10.7f), random.nextFloat(300f, 350f))
        };

        Course[] courses = {new Course(random.nextFloat(100f, 200f)),
                new Course(random.nextFloat(201f, 320f)),
                new Course(random.nextFloat(321f, 410f))};

        System.out.println("----------------------------------------------------------------------------------");
        team[0].teamName();

        int j = 0;
        int l = 0;
        for (Course course : courses) {
            j++;
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(j + "-я дистанция. Длина дистанции: " + course.getLength() + " м.");
            l = 0;
            System.out.println("----------------------------------------------------------------------------------");
            for (int i = 0; i < team.length; i++) {
                l++;
                System.out.println(l + "-й участник команды");
                course.getTimeToOvercome(team[i]);
            }
        }
    }
}