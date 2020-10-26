package engine.api;

import engine.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class TaskController {
    @Autowired
    private Quizzes quizzes;

    public TaskController() {
    }

    //Get a quiz by id
    @GetMapping(path = "/api/quizzes/{id}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable int id) {
        try {
            return new ResponseEntity<>(
                    quizzes.getQuizById(id),
                    HttpStatus.OK);
        } catch (QuizNotFoundException exception) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
    }

    // Get all quizzes
    @GetMapping(path = "/api/quizzes")
    public ResponseEntity<List<Quiz>> getQuizzes() {
        return new ResponseEntity<>(
                quizzes.getList(),
                HttpStatus.OK);
    }

    // Solving a quiz
    @PostMapping(path = "/api/quizzes/{id}/solve", consumes = "application/json")
    public ResponseEntity<QuizResult> solveQuiz(@PathVariable int id, @RequestBody Answer answer) {
        try {
            return new ResponseEntity<>(
                    new QuizResult(quizzes.getQuizById(id).answerEqualsTo(answer.getAnswer())),
                    HttpStatus.OK);

        } catch (QuizNotFoundException exception) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
    }

    // Create a new quiz
    @PostMapping(path = "/api/quizzes", consumes = "application/json")
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        if (quiz.getAnswer() == null) {
            quiz.setAnswer(new ArrayList<>());
        }
        quizzes.addQuiz(quiz);
        return quiz;
    }
}
