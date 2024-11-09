package interface_adapter.food_logging;

import data.Food;

public class LogFoodController {
    private final LogFoodInputBoundary logFoodUseCaseInteractor;

    public LogFoodController(LogFoodInputBoundary logFoodUseCaseInteractor) {
        this.logFoodUseCaseInteractor = logFoodUseCaseInteractor;
    }

    public void execute(String food_consumed){
        final LogFoodInputData foodInputData = new LogFoodInputData(food_consumed);
        logFoodUseCaseInteractor.execute(foodInputData);
    }
}
