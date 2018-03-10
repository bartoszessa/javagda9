package zad3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GameOperator implements Playable{

    List<Playable> games = new ArrayList<>();
    public static final int PRINTER_WIDTH = 40;
    ProperPrinter pp = new ProperPrinter(PRINTER_WIDTH);


    public GameOperator() {
        games.add(new GuessNumber());
        games.add(new HangMan());

    }

    public void start(){

        for(Playable playable: games){
            pp.print(playable.getDescription()+ " "+playable.getNumber());
        }

        Scanner scanner = new Scanner(System.in);
        int numberOfGame = scanner.nextInt();
        System.out.println("you chose: "+numberOfGame);
        getGame(numberOfGame).start();
    }

    private Playable getGame(int numberOfGame) {
        Optional<Playable> optional = games.stream().filter(x->x.getNumber()==numberOfGame)
                                                    .findFirst();

        if(optional.isPresent()) return optional.get();
        return games.get(0);
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
