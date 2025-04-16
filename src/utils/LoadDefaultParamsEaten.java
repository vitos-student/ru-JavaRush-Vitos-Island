package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/* не реализованнный класс */
/*попытка подгрузить данные из файла*/

public class LoadDefaultParamsEaten {

public static void pp() {
    String[][] ar;
    String[] ar1;
    try {
        for (String line : Files.readAllLines(Paths.get("C:\\Users\\фвьшт\\IdeaProjects\\ru-JavaRush-Vitos-Island\\src\\resources\\beingЕaten.txt"))) {

            //  System.out.println(line);
            ar1 = line.split("    ");
            // System.out.println(ar1);

            for (String str : ar1) {
                System.out.println(str);

            }

        }
    } catch (
            IOException e) {
        throw new RuntimeException(e);
    }
    ;
    System.out.println("-------------------------------");

}
}
