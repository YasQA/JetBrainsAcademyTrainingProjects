package engine.api;

import com.fasterxml.jackson.databind.JsonNode;
import engine.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping(path = "/api/quizzes/{id}/solve")
    public ResponseEntity<QuizResult> solveQuiz(@PathVariable int id, @RequestParam("answer") String answer) {
        try {
            QuizResult result = new QuizResult(quizzes.getQuizById(id).getAnswer() == Integer.parseInt(answer));
            return new ResponseEntity<>(
                    result,
                    HttpStatus.OK);
        } catch (QuizNotFoundException exception) {
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
    }

    // Create a new quiz
    @PostMapping(path = "/api/quizzes", consumes = "application/json")
    public Quiz addQuiz(@RequestBody JsonNode jsonNode) {
        List<String> options = new ArrayList<>();
        Iterator<JsonNode> iterator = jsonNode.get("options").elements();

        while (iterator.hasNext()) {
            JsonNode opt = iterator.next();
            options.add(opt.asText());
        }

        Quiz quiz = new Quiz(quizzes.getId(),
                jsonNode.get("title").asText(),
                jsonNode.get("text").asText(),
                options,
                jsonNode.get("answer").asInt());

        quizzes.addQuiz(quiz);

        return quiz;
    }

}
