package homeWorkLesson4;

import java.util.*;
import java.util.stream.Collectors;

public class Array {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add("Video");
        arrayList.add("World");
        arrayList.add("Wear");
        arrayList.add("Magic");
        arrayList.add("Wear");
        arrayList.add("Local");
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Home");
        arrayList.add("Name");
        arrayList.add("Series");
        arrayList.add("Magic");
        System.out.println(arrayList);
        System.out.println(arrayList.size());

        HashSet<String> hashSet = new HashSet<>(arrayList);
        System.out.println("Список уникальных слов массива: " + hashSet);
        System.out.println(hashSet.size());

        Map<String, Integer> frequency = arrayList.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        frequency.forEach((k, v) -> System.out.println("Слово <" + k + "> встречается в массиве: " + v + " раз(-а)"));
    }
}