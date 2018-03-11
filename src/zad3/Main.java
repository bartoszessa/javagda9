package zad3;

import zad3.millionaires.WhoWantsToBeMillionaire;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WhoWantsToBeMillionaire millionaire = new WhoWantsToBeMillionaire();
        millionaire.start();

        GameOperator gameOperator = new GameOperator();
        gameOperator.start();
    }
}
