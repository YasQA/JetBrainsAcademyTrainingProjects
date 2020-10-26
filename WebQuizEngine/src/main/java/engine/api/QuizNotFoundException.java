package engine.api;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(int id) {
        super("Quiz not found: " + id);
    }
}
