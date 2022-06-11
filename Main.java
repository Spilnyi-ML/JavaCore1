package homeWorkLesson5;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<AppData> appData = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ReaderLesson5.csv"))) {
            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                String[] valueArray = temp.split(";" );
                appData.add(new AppData(valueArray[0], valueArray[1], valueArray[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(appData);

        try (PrintWriter printWriter = new PrintWriter("WriterLesson5.csv")) {
            for (AppData appData1 : appData){
                printWriter.println(appData1.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}