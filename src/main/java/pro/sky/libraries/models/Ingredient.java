package pro.sky.newyummyrecipes.models;
import lombok.Data;

@Data

public class Ingredient {
    private String title;
    private int amount;
    private String measureUnit;

    public Ingredient(String title,
                      int amount,
                      String measureUnit) {
        this.title = title;
        this.amount = amount;
        this.measureUnit = measureUnit;
    }

    public Ingredient() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }
}
