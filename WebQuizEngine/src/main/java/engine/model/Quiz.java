package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties(allowSetters = true, value = { "answer" })
public class Quiz {
    private int id;
    @NotEmpty(message = "title is required")
    private final String title;
    @NotEmpty(message = "text is required")
    private final String text;
    @NotEmpty
    @Size(min = 2, message = "should contain at least 2 items")
    private final List<String> options;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    public Quiz (int id, String title, String text, List<String> options, List<Integer> answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<Integer> answer) {
        this.answer = answer;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean answerEqualsTo(List<Integer> newAnswer) {
        if(answer == null) {
            answer = new ArrayList<>();
        }

        if(answer.containsAll(newAnswer) && newAnswer.containsAll(answer)) {
            return true;
        }
        return false;
    }
}
