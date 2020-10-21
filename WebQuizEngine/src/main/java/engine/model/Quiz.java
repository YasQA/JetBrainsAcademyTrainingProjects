package engine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quiz {
    private String title;
    private String text;
    //private Options options; ################
    private List<String> options;
    //private int correctAnswerIndex; ################

    public Quiz (String title, String text, List<String> options, int index) {   // #########
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

//    public Options getOptions() {         //#######################
//        return options;
//    }

    public List<String> getOptions() {
        return options;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public int getCorrectAnswerIndex() {
//        return correctAnswerIndex;
//    }
}
