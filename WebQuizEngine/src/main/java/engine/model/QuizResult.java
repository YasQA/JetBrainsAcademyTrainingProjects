package engine.model;

public class QuizResult {
    private boolean success;
    private String feedback;

    public QuizResult(boolean result) {
        if (result) {
            this.success = true;
            this.feedback = "Congratulations, you're right!";
        } else {
            this.success = false;
            this.feedback = "Wrong answer! Please, try again.";
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}
