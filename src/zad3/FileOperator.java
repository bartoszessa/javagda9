package zad3;

import java.util.Arrays;

public class FileOperator {
    public static void main(String[] args) {
        String[]arr = "a,b,c,f,d,g".split(",");
        Arrays.stream(arr).forEach(x-> System.out.print(x));

    }
}
