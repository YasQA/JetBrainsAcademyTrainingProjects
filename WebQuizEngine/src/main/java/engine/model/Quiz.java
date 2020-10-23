package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(value = { "answer" })
public class Quiz {
    private int id;
    private String title;
    private String text;
    private List<String> options;
    private Integer answer;

    public Quiz (int id, String title, String text, List<String> options, int answer) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAnswer() {
        return answer;
    }
}
