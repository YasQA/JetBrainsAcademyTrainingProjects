package engine.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties(allowSetters = true, value = { "answer" })
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private Long id;

    @NotEmpty(message = "title is required")
    private String title;

    @NotEmpty(message = "text is required")
    private String text;

    @ElementCollection(targetClass=String.class)
    @NotEmpty
    @Size(min = 2, message = "should contain at least 2 items")
    private List<String> options;

    @ElementCollection(targetClass=Integer.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Integer> answer;

    protected Quiz() {}

    public Quiz (Long id, String title, String text, List<String> options, List<Integer> answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public boolean answerEqualsTo(List<Integer> newAnswer) {
        answer = answer != null ? answer : new ArrayList<>();
        return (answer.containsAll(newAnswer) && newAnswer.containsAll(answer));
    }
}
