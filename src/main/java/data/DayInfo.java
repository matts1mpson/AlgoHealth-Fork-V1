package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;

public class DayInfo {
    private final Date date;
    private float totalCalories;
    private List<Food> foodLog;

    public DayInfo(Date date) {
        this.date = date;
        totalCalories = 0;
        foodLog = new ArrayList<>();
    }

    public Date getDate() {
        return this.date;
    }

    public float getTotalCalories() {
        return this.totalCalories;
    }

    public List<Food> getFoodLog() {
        return foodLog;
    }

    public void addToFoodLog(Food newFood) {  // do we wanna use a setter for this? maybe that would be better
        this.foodLog.add(newFood);
    }

    public void setTotalCalories(float newTotalCalories) {
        this.totalCalories = newTotalCalories;
    }

    public void setFoodLog(List<Food> foodLog) {
        this.foodLog = foodLog;
    }
}