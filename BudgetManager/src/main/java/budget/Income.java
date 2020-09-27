package budget;

import java.io.Serializable;

public class Income implements Serializable {
    private double income;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
}
