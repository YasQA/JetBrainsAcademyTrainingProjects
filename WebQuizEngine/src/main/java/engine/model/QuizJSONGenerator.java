package engine.model;

import java.util.List;

public class QuizJSONGenerator {
    public String generate(Quiz quiz) {
        return "{\n" +
                "  \"title\": \"The Java Logo\",\n" +
                "  \"text\": \"What is depicted on the Java logo?\",\n" +
                "  \"options\": [\"Robot\",\"Tea leaf\",\"Cup of coffee\",\"Bug\"]\n" +
                "}";

    }

//    public String generate(Quiz quiz) {
//        return "{\n" +
//                "  \"title\": \"" + quiz.getTitle() + "\",\n" +
//                "  \"text\": \"" + quiz.getQuestions() + "\"\n" +
//                "  \"options\": [\"Robot\",\"Tea leaf\",\"Cup of coffee\",\"Bug\"]\n" +
//                "}";
//    }
}
