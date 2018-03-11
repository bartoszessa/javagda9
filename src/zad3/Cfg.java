package zad3;

import java.io.FileNotFoundException;
import java.util.List;

public class Cfg {

    private FileOperator fileOperator = new FileOperator();
    public static final String CFG_FILE_PATH = "src/zad3/files/gameopt.cfg";
    public static final String SEPARATOR = "=";

    private int guessNumberEasyLives=4;
    private int guessNumberHardLives=3;
    private int guessNumberMediumLives=4;
    private int guessNumberEasyRandom=10;
    private int guessNumberMediumRandom=25;
    private int guessNumberHardRandom=100;
    private int printerWidth = 40;

    public Cfg()  {
        loadValues();
    }

    private void loadValues()  {

        List<String> lines = null;
        lines = fileOperator.getLines(CFG_FILE_PATH);

        for (String line : lines) {

            if (line.contains("printer_width")) {
                printerWidth = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_easy_lives")) {
                guessNumberEasyLives = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_medium_lives")) {
                guessNumberMediumLives = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_hard_lives")) {
                guessNumberHardLives = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_easy_random")) {
                guessNumberEasyRandom = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_medium_random")) {
                guessNumberMediumRandom = Integer.parseInt(line.split(SEPARATOR)[1]);
            } else if (line.contains("gn_hard_random")) {
                guessNumberHardRandom = Integer.parseInt(line.split(SEPARATOR)[1]);
            }


        }

    }

    public int getGuessNumberEasyLives() {
        return guessNumberEasyLives;
    }

    public int getGuessNumberHardLives() {
        return guessNumberHardLives;
    }

    public int getGuessNumberMediumLives() {
        return guessNumberMediumLives;
    }

    public int getPrinterWidth() {
        return printerWidth;
    }

    public int getGuessNumberEasyRandom() {
        return guessNumberEasyRandom;
    }

    public int getGuessNumberMediumRandom() {
        return guessNumberMediumRandom;
    }

    public int getGuessNumberHardRandom() {
        return guessNumberHardRandom;
    }

    /*
    printer_width=42
gn_easy_lives=777
gn_medium_lives=4
gn_hard_lives=3
gn_easy_random=10
gn_medium_random=50
gn_hard_random=100
     */
}
