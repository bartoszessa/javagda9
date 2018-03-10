package zad3;

public enum Difficulty {

    EASY(1),
    MEDIUM(2),
    HARD(3);

    private int value;

    Difficulty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Difficulty getFromValue(int value){
        for(Difficulty difficulty:Difficulty.values()){
            if(difficulty.getValue()==value) return difficulty;
        }
        return EASY;
    }
}
