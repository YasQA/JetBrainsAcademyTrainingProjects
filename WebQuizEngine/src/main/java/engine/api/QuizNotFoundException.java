package engine.api;

public class QuizNotFoundException extends RuntimeException {
    public QuizNotFoundException(Long id) {
        super("Quiz not found: " + id);
    }
}
