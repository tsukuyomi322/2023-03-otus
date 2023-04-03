package pohlebaev.homework.one.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.NumberFormat;
import pohlebaev.homework.one.dao.QuestionDao;
import pohlebaev.homework.one.dao.QuestionDaoImpl;
import pohlebaev.homework.one.model.Question;
import pohlebaev.homework.one.model.QuestionImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    QuestionDaoImpl questionDaoImpl;

    CsvMapper csvMapper;

    CsvSchema csvSchema;

    @BeforeEach
    void setUp() {
        csvMapper = new CsvMapper();
        csvSchema = csvMapper.schema().withHeader();
        questionDaoImpl = new QuestionDaoImpl("testquestions.csv", csvMapper);
    }

    @Test
    void getAllQuestionsAndCheckErrors_success() throws IOException {
        List<Question> expectedList = getQuestionList();
        List<Question> actualList = questionDaoImpl.getAllQuestions();
        assertArrayEquals(expectedList.toArray(), actualList.toArray());

    }

    List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<>();
        Question question1 = new QuestionImpl();
        question1.setQuestion("2+2");
        question1.setAnswer("Four");
        questionList.add(question1);

        Question question2 = new QuestionImpl();
        question2.setQuestion("2+1");
        question2.setAnswer("Three");
        questionList.add(question2);

        Question question3 = new QuestionImpl();
        question3.setQuestion("2+0");
        question3.setAnswer("Two");
        questionList.add(question3);

        Question question4 = new QuestionImpl();
        question4.setQuestion("2+3");
        question4.setAnswer("Five");
        questionList.add(question4);

        Question question5 = new QuestionImpl();
        question5.setQuestion("2+4");
        question5.setAnswer("Six");
        questionList.add(question5);

        return questionList;
    }



}