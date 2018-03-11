package zad3;

import zad1.Visit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileOperator {

    public List<String> getLines(String fileName) {

        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
