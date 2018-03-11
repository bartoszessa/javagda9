package zad3.millionaires;

import java.util.List;

public class Question {

    private String content;
    private List<Answer> answers;
    private int level;

    public Question(String content, List<Answer> answers, int level) {
        this.content = content;
        this.answers = answers;
        this.level = level;
    }

    public Question() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", answers=" + answers +
                ", level=" + level +
                '}';
    }
}
