package engine.api;

import engine.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TaskController {

    String title = "The Java Logo";
    String text = "What is depicted on the Java logo?";

    Option option1 = new Option("Robot", false);
    Option option2 = new Option("Tea leaf", false);
    Option option3 = new Option("Cup of coffee", true);
    Option option4 = new Option("Bug", false);

//    Options options = new Options(Arrays.asList(option1, option2, option3, option4)); #####################

    List<String> options = Arrays.asList(option1.getText(), option2.getText(), option3.getText(), option4.getText());
    Quiz quiz = new Quiz(title, text, options, 2);

    public TaskController() {
    }

    @GetMapping(path = "/api/quiz")
    public Quiz getQuiz() {
        return quiz;
    }

    @PostMapping(path = "/api/quiz")
    public QuizResult addTask(@RequestParam("answer") String answer) {
        QuizResult result = new QuizResult(Integer.parseInt(answer) == 2); //##################
        return result;
    }

}
