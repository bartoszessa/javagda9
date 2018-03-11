package zad3;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;
import java.util.stream.Collectors;

public class HangMan implements Playable {

    private final String WORDS_FILEPATH = "src/zad3/files/words.txt";
    private ProperPrinter pp = new ProperPrinter(GameOperator.PRINTER_WIDTH);
    private FileOperator fileOperator = new FileOperator();
    private String[] wordToGuess;
    private String[] usersWord;
    private Difficulty difficulty;
    private int livesLeft;

    @Override
    public void start() {

        Scanner scanner = new Scanner(System.in);
        setDifficultyAndStartingValues();

        boolean isWon = false;

        while (!isWon && livesLeft >= 0) {

            pp.print("Lives left: " + livesLeft);
            printUsersWord();
            pp.print("Give me letter.");
            String letter = scanner.nextLine();
            boolean guessedLetter = false;
            for (int i = 0; i < wordToGuess.length; i++) {
                if (wordToGuess[i].equals(letter)) {
                    usersWord[i] = letter;
                    guessedLetter = true;
                }
            }
            if (!guessedLetter) {
                livesLeft--;
                pp.print("No!");
            } else {
                pp.print("Nice!");

            }

            if (isArrayFilled()) {
                isWon = true;
            }
        }

        if (isWon) {
            pp.print("Congratulations!!");
            printUsersWord();
        } else {
            pp.print("You lost all your lives :(");
        }

    }

    private boolean isArrayFilled() {
        for (String letter : usersWord) {
            if (letter.equals("_")) return false;
        }
        return true;
    }

    private void printUsersWord() {
        String result = "";
        for (int i = 0; i < usersWord.length; i++) {
            result += usersWord[i];
        }

        pp.print(result);
    }

    private void setDifficultyAndStartingValues() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<String> words = fileOperator.getLines(WORDS_FILEPATH);
        pp.printDifficulties();
        int diff = scanner.nextInt();
        difficulty = Difficulty.getFromValue(diff);

        int wordLength;
        livesLeft = 6;
        Comparator<String> compByLength = (aName, bName) -> aName.length() - bName.length();
        wordLength = words.stream().sorted(compByLength).findFirst().get().length();

        if (difficulty == Difficulty.MEDIUM) {
            wordLength++;
            livesLeft--;
        } else if (difficulty == Difficulty.HARD) {

            livesLeft -= 2;
            wordLength += 2;
        }

        int finalWordLength = wordLength;
        List<String> wordsOfLength = words.stream().filter(x -> x.length() == finalWordLength)
                .collect(Collectors.toList());
        wordToGuess = wordsOfLength.get(random.nextInt(wordsOfLength.size())).split("");
        usersWord = new String[wordToGuess.length];

        for (int i = 0; i < usersWord.length; i++) usersWord[i] = "_";

    }

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public String getDescription() {
        return "Hangman";
    }
}
