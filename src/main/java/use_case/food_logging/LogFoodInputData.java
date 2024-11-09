package use_case.food_logging;
import data.Food;

public class LogFoodInputData {
    private final Food food;

    public LogFoodInputData(Food food) {
        this.food = food;
    }

    Food getFood() {
        return food;
    }
}
