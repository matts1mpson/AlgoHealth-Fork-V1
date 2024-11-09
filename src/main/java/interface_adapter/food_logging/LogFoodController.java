package log_food;

import data.Food;

public class LogFoodController {
    private final LogFoodInputBoundary logFoodUseCaseInteractor;

    public LogFoodController(LogFoodInputBoundary logFoodUseCaseInteractor) {
        this.logFoodUseCaseInteractor = logFoodUseCaseInteractor;
    }

    public void execute(Food food_consumed){
        final LogFoodInputData foodInputData = new LogFoodInputData(food_consumed);
        logFoodUseCaseInteractor.execute(foodInputData);
    }
}
