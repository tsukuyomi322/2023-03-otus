package pohlebaev.homework.one.service;

import pohlebaev.homework.one.model.Question;
import pohlebaev.homework.one.dao.QuestionDao;

import java.util.List;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void startAskQuestion() {
        List<Question> questionList = questionDao.getAllQuestionsAndCheckErrors();
        try (Scanner scanner = new Scanner(System.in)) {
            int correctAnswer = 0;
            System.out.println("Enter your name please:");
            String name = scanner.nextLine();
            System.out.println("Hello " + name + ", Let's start our quiz");
            for (Question question : questionList) {
                System.out.println(question.getQuestion());
                String answer = scanner.nextLine();
                if(question.isAnswerCorrect(answer)) {
                    correctAnswer++;
                }
            }
            System.out.println(name + ", amount of correct answers: " + correctAnswer +"\n" + "quiz is over");
        }
    }
}
g