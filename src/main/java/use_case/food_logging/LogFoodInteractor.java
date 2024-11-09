package log_food;

public class LogFoodInteractor implements LogFoodInputBoundary {
    private final LogFoodDataAccessInterface logFoodDataAccessObject;
    private final LogFoodOutputBoundary logFoodPresenter;

    public LogFoodInteractor(LogFoodDataAccessInterface logFoodDataAccessObject) {
        this.logFoodDataAccessObject = logFoodDataAccessObject;
    }
}
