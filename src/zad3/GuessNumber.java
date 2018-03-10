package zad3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber implements Playable{

    private int livesLeft;
    private int randomBound;
    private Difficulty difficulty;
    private ProperPrinter pp = new ProperPrinter(GameOperator.PRINTER_WIDTH);
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void start() {

        pp.delim();
        setDifficultyAndStartingValues();
        startGame();

    }

    private void startGame() {
        Random random = new Random();
        boolean won= false;
        int numberToGuess = random.nextInt(randomBound);
        while(!won&&livesLeft>=0){
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
            pp.print("Lives left: "+livesLeft);
        }
        if(won) pp.print("Good job!");
        else pp.print("Oops! You lost all your lives.");
    }

    private void setDifficultyAndStartingValues(){
        pp.printDifficulties();
        int diff = scanner.nextInt();
        difficulty = Difficulty.getFromValue(diff);

        if(difficulty==Difficulty.EASY){
            livesLeft = 4;
            randomBound = 10;
        }
        else if(difficulty==Difficulty.MEDIUM){
            livesLeft = 5;
            randomBound =20;
        }
        else{
            livesLeft = 4;
            randomBound = 100;
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
