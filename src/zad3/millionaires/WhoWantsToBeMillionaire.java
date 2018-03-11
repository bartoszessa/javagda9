package zad3.millionaires;

import zad3.Cfg;
import zad3.FileOperator;
import zad3.Playable;
import zad3.ProperPrinter;

import java.util.*;
import java.util.stream.Collectors;

public class WhoWantsToBeMillionaire implements Playable {

    private ProperPrinter pp;
    private List<Question> questions;
    private final String QUESTIONS_FILEPATH = "src/zad3/files/questions.txt";


    @Override
    public void start() {

        Cfg cfg = new Cfg();
        pp = new ProperPrinter(cfg.getPrinterWidth());
        Scanner scanner = new Scanner(System.in);
        loadQuestions();

        System.out.println(questions);
        Random random = new Random();
        while (true) {

            Question question = questions.get(random.nextInt(questions.size()));
            pp.print(question.getContent());
            pp.spacer();
            for (int i = 0; i < question.getAnswers().size(); i++) {
                pp.print(i + ": " + question.getAnswers().get(i).getContent());
            }
            pp.delim();
            int answer = scanner.nextInt();

            if (question.getAnswers().get(answer).isCorrect()) {
                pp.print("Nice! " + question.getAnswers().get(answer).getContent() + " is correct! ");
            } else {
                pp.print("You lose!");
                break;
            }
        }
    }

    @Override
    public int getNumber() {
        return 3;
    }

    private void ripQuestions() {
        Random random = new Random();
        Comparator<Question> compByLevel = (q1, q2) -> q1.getLevel() - q2.getLevel();

        List<Question> ripped = new LinkedList<>();
        List<Question> sorted = questions.stream().sorted(compByLevel).collect(Collectors.toList());

        List<List<Question>> groupedQuestions = new ArrayList<>();
        for (int i = sorted.get(0).getLevel(); i <= sorted.get(sorted.size() - 1).getLevel(); i++) {
            int finalI = i;
            List<Question> questionsOnLevel = sorted.stream().filter(x -> x.getLevel() == finalI).collect(Collectors.toList());
            groupedQuestions.add(questionsOnLevel);
        }

        for (List<Question> levelledList : groupedQuestions) {
            ripped.add(levelledList.get(random.nextInt(levelledList.size())));
        }
        questions = ripped;
    }

    @Override
    public String getDescription() {
        return "WhoWantsToBeMillionaire";
    }

    private void loadQuestions() {

        questions = new ArrayList<>();
        FileOperator fileOperator = new FileOperator();
        List<String> lines = fileOperator.getLines(QUESTIONS_FILEPATH);

        for (String line : lines) {
            String[] splits = line.split(";");

            Question question = new Question();
            question.setContent(splits[0]);

            Answer answer1 = new Answer(splits[1]);
            Answer answer2 = new Answer(splits[2]);
            Answer answer3 = new Answer(splits[3]);
            Answer answer4 = new Answer(splits[4]);

            Answer[] answers = {answer1, answer2, answer3, answer4};
            answers[Integer.parseInt(splits[5])].setCorrect(true);
            question.setAnswers(Arrays.asList(answers));
            question.setLevel(Integer.parseInt(splits[6]));
            questions.add(question);
        }

        ripQuestions();

    }
}
