package pohlebaev.homework.one.dao;

import pohlebaev.homework.one.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAllQuestionsAndCheckErrors();
}
