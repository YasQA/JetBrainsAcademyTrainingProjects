package engine.api;

import engine.dao.QuizRepository;
import engine.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
public class TaskController {
    @Autowired
    private QuizRepository quizzes;

    public TaskController() {
    }

    //Get a quiz by id
    @GetMapping(path = "/api/quizzes/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
        if (quizzes.findById(id).isPresent()) {
            return quizzes.findById(id).get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Get all quizzes
    @GetMapping(path = "/api/quizzes")
    public List<Quiz> getQuizzes() {
        List<Quiz> quizList = new ArrayList<>();
        quizzes.findAll().forEach(quizList::add);
        return quizList;
    }

    // Solving a quiz
    @PostMapping(path = "/api/quizzes/{id}/solve", consumes = "application/json")
    public QuizResult solveQuiz(@PathVariable Long id, @RequestBody Answer answer) {
        if (quizzes.findById(id).isPresent()) {
            return new QuizResult(quizzes.findById(id).get().answerEqualsTo(answer.getAnswer()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new quiz
    @PostMapping(path = "/api/quizzes", consumes = "application/json")
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        if (quiz.getAnswer() == null) {
            quiz.setAnswer(new ArrayList<>());
        }
        quizzes.save(quiz);
        return quiz;
    }
}
