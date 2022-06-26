package homeWorkLesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student( "Ivan", "Ivanov", "IvanovII@mail.ru",
                Arrays.asList(
                new Course(1, "Базы данных"),
                new Course(2, "Основы Python"),
                new Course(4, "Основы тест-аналитики"),
                new Course(6, "Тестирование веб-приложений"),
                new Course(7, "Java Core для тестировщиков")
        )));
        students.add(new Student( "Petr", "Petrov", "PetrovPP@mail.ru",
                Arrays.asList(
                new Course(1, "Базы данных"),
                new Course(3, "Linux. Рабочая станция")
        )));
        students.add(new Student( "Kirill", "Kirillov", "KirillovKK@mail.ru",
                Arrays.asList(
                new Course(2, "Основы Python"),
                new Course(3, "Linux. Рабочая станция"),
                new Course(1, "Базы данных")
        )));
        students.add(new Student( "Fedor", "Fedorov", "FedorovFF@mail.ru",
                Arrays.asList(
                new Course(2, "Основы Python"),
                new Course(6, "Тестирование веб-приложений"),
                new Course(1, "Базы данных"),
                new Course(5, "Основы ручного тестирования")
        )));
        students.add(new Student( "Ilya", "Ilyin", "IlyinII@mail.ru",
                Arrays.asList(
                new Course(2, "Основы Python"),
                new Course(7, "Java Core для тестировщиков"),
                new Course(1, "Базы данных"),
                new Course(4, "Основы тест-аналитики")
        )));

        System.out.println("ToDo: Написать функцию, принимающую список Student и возвращающую список уникальных " +
                "курсов, на которые подписаны студенты.");
        System.out.println(students.stream()
                .map(s -> s.getAllCourses())
                .flatMap(w -> w.stream())
                .map(w -> w.getCourseName())
                .collect(Collectors.toSet())
        );

        System.out.println();
        System.out.println("ToDo: Написать функцию, принимающую на вход список Student и возвращающую список из трех " +
                "самых любознательных (любознательность определяется количеством курсов). ");

        System.out.println(students.stream()
                        .sorted((o1, o2) -> o2.getAllCourses().size() - o1.getAllCourses().size())
                        .limit(3)
                        .map(s -> s.getStudentName() + " " + s.getStudentSurname())
                        .collect(Collectors.toList())
        );

        System.out.println();
        System.out.println("ToDo: Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую " +
                "список студентов, которые посещают этот курс.");

        getStudent(students, "Базы данных");
        getStudent(students, "Linux. Рабочая станция");

        }


        public static void getStudent(List<Student> students, String courseName){
        // Реализовать вывод Имени и Фамилии студентов, которые посещают вводимый курс я не смог!
            students.stream()
                    .map(s -> s.getAllCourses())
                    .flatMap(w -> w.stream())
                    .filter(s -> s.getCourseName() == courseName)
          //          .map(students.get().getStudentSurname())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
          //  students.parallelStream().map(s -> s.getStudentName() + " " + s.getStudentSurname())
          //          .collect(Collectors.toList())
          //           .forEach(System.out::println);
    }
}