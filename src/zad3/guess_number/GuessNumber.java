package zad3.guess_number;

import zad3.*;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Playable {

    private int livesLeft;
    private int randomBound;
    private Difficulty difficulty;
    private ProperPrinter pp = new ProperPrinter(GameOperator.PRINTER_WIDTH);
    private Scanner scanner = new Scanner(System.in);
    private Cfg cfg;

    @Override
    public void start() {

        cfg = new Cfg();
        pp.delim();
        setDifficultyAndStartingValues();
        startGame();

    }

    private void startGame() {
        Random random = new Random();
        boolean won= false;
        int numberToGuess = random.nextInt(randomBound);
        while(!won&&livesLeft>=0){
            pp.print("Lives left: "+livesLeft);
            pp.print("Give number: ");

            int number = scanner.nextInt();

            if(number>numberToGuess){
                pp.print("to big!");
                livesLeft--;
            }
            else if(number<numberToGuess){
                pp.print("to small!");
                livesLeft--;
            }
            else won = true;
        }
        if(won) pp.print("Good job!");
        else pp.print("Oops! You lost all your lives.");
    }

    private void setDifficultyAndStartingValues(){
        pp.printDifficulties();
        int diff = scanner.nextInt();
        difficulty = Difficulty.getFromValue(diff);

        if(difficulty==Difficulty.EASY){
            livesLeft = cfg.getGuessNumberEasyLives();
            randomBound = cfg.getGuessNumberEasyRandom();
        }
        else if(difficulty==Difficulty.MEDIUM){
            livesLeft = cfg.getGuessNumberMediumLives();
            randomBound =cfg.getGuessNumberMediumRandom();
        }
        else{
            livesLeft = cfg.getGuessNumberHardLives();
            randomBound = cfg.getGuessNumberHardRandom();
        }
    }

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public String getDescription() {
        return "Super kewl guessing number";
    }
}
