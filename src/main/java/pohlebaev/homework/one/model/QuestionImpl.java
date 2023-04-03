package pohlebaev.homework.one.model;

import java.util.Objects;

public class QuestionImpl implements Question {

    private String question;

    private String answer;

    public QuestionImpl() {

    }

    public QuestionImpl(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean isAnswerCorrect(String answer) {
        return this.getAnswer().equalsIgnoreCase(answer.trim());
    }

    @Override
    public String toString() {
        return "QuestionImpl{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionImpl question1 = (QuestionImpl) o;
        return question.equals(question1.question) && answer.equals(question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
}
