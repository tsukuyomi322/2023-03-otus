package pohlebaev.homework.one.model;

public interface Question {
    String getQuestion();

    String getAnswer();

    void setQuestion(String question);

    void setAnswer(String question);

    boolean isAnswerCorrect(String answer);

}
