package pohlebaev.homework.one.dao;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import pohlebaev.homework.one.model.Question;
import pohlebaev.homework.one.model.QuestionImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    private final String fileName;

    private final CsvMapper csvMapper;

    private final CsvSchema csvSchema;

    public QuestionDaoImpl(String fileName, CsvMapper csvMapper) {
        this.fileName = fileName;
        this.csvMapper = csvMapper;
        this.csvSchema = csvMapper.schema().withHeader();
    }

    @Override
    public List<Question> getAllQuestionsAndCheckErrors() {
        try {
            return getAllQuestions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Question> getAllQuestions() throws IOException {
        InputStream csvInputStream = new ClassPathResource(fileName).getInputStream();
        MappingIterator<Question> csvRowsReader =
                csvMapper.readerFor(QuestionImpl.class).with(csvSchema).readValues(csvInputStream);
        return csvRowsReader.readAll();
    }
}

