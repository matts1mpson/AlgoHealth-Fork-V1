package use_case.food_logging;

public class LogFoodInteractor implements LogFoodInputBoundary {
    private final LogFoodDataAccessInterface logFoodDataAccessObject;
    private final LogFoodOutputBoundary logFoodPresenter;

    public LogFoodInteractor(LogFoodDataAccessInterface logFoodDataAccessObject) {
        this.logFoodDataAccessObject = logFoodDataAccessObject;
    }
}
