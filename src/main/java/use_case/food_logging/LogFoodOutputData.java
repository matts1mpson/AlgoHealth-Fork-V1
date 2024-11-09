package use_case.food_logging;

import java.util.HashMap;

public class LogFoodOutputData {
    private final String foodName;
    private final HashMap<String, HashMap<String, Object>> macronutrients;

    //output food name and calories calculated based on amount consumed.
    public LogFoodOutputData(String foodName, HashMap<String, HashMap<String, Object>> Macronutrient) {
        this.foodName = foodName;
        this.macronutrients = Macronutrient;
    }
}
