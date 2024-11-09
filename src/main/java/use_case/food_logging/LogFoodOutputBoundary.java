package log_food;

public interface LogFoodOutputBoundary {
    void prepareSuccessView(LogFoodOutputBoundary outputData);

    void prepareFailView(String errorMessage);

}
