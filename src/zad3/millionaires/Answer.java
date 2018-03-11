package zad3.millionaires;

public class Answer {
    private String content;
    private boolean isCorrect;

    public Answer(String content, boolean isCorrect) {

    }

    public Answer(String answer) {
        this.content = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
