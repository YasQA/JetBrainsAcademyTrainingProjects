package engine.model;

import java.util.List;
import java.util.stream.IntStream;

public class Options {
    private long id;
    public List<Option> list;

    public Options(List<Option> list) {
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCorrectAnswerIndex() {
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).isCorrect())
                .findFirst()
                .orElse(-1);
    }
}
