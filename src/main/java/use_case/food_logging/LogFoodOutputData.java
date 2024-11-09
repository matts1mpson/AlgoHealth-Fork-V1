package log_food;

import java.util.HashMap;

public class LogFoodOutputData {
    private final String foodName;
    private final HashMap<String, Object> calories;

    //output food name and calories calculated based on amount consumed.
    public LogFoodOutputData(String foodName, HashMap<String, Object> calories) {
        this.foodName = foodName;
        this.calories = calories;
    }
}
