package zad3;

import zad3.guess_number.GuessNumber;
import zad3.hang_man.HangMan;
import zad3.millionaires.WhoWantsToBeMillionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GameOperator implements Playable{

    List<Playable> games = new ArrayList<>();
    public static int PRINTER_WIDTH;
    ProperPrinter pp;

    public GameOperator() {
        Cfg cfg = new Cfg();
        PRINTER_WIDTH = cfg.getPrinterWidth();
        pp = new ProperPrinter(cfg.getPrinterWidth());
        games.add(new GuessNumber());
        games.add(new HangMan());
        games.add(new WhoWantsToBeMillionaire());

    }

    public void start(){
        int numberOfGame=0;
        while(numberOfGame!=-1){
            pp.delim();
            pp.print("Welcome!! Choose your game.");
            pp.delim();
            for(Playable playable: games){
                pp.print(playable.getDescription()+ " "+playable.getNumber());
            }

            Scanner scanner = new Scanner(System.in);
            numberOfGame = scanner.nextInt();
            pp.spacer();
            getGame(numberOfGame).start();
        }

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
