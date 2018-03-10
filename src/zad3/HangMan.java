package zad3;

public class HangMan implements Playable{

    private ProperPrinter pp = new ProperPrinter(GameOperator.PRINTER_WIDTH);

    @Override
    public void start() {

        pp.print("To be continued");
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
