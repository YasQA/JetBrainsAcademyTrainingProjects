package engine.model;

import engine.api.QuizNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.IntStream;

@Component
public class Quizzes {
    private static int id = 0; //remember place to add new Quiz
    private List<Quiz> list = new ArrayList<>();
    //private Map<Integer, Quiz> list1 = new HashMap<>();

    public Quizzes() {};

    public int getId() {
        return id;
    }

    public void addQuiz(Quiz quiz) {
        list.add(quiz);
        id++;
    }

    public Quiz getQuizById(int id) {
        return list.get(
                IntStream.range(0, list.size())
                .filter(i -> list.get(i).getId() == id)
                .findFirst()
                .orElseThrow(() -> new QuizNotFoundException(id)));
    }

    public List<Quiz> getList() {
        return list;
    }
}