package pohlebaev.homework.one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pohlebaev.homework.one.service.QuestionService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService =  applicationContext.getBean(QuestionService.class);
        questionService.startAskQuestion();


    }
}