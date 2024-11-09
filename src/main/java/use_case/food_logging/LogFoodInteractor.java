package use_case.food_logging;
import api.populateFromUsda;
import api.callUsdaApi;
import data.Food;

public class LogFoodInteractor implements LogFoodInputBoundary {
    private final LogFoodDataAccessInterface logFoodDataAccessObject;
    private final LogFoodOutputBoundary logFoodPresenter;
    private final populateFromUsda foodConstruct;


    public LogFoodInteractor(LogFoodDataAccessInterface logFoodDataAccessObject, LogFoodOutputBoundary logFoodPresenter,
                             populateFromUsda foodConstruct) {
        this.logFoodDataAccessObject = logFoodDataAccessObject;
        this.logFoodPresenter = logFoodPresenter;
        this.foodConstruct = foodConstruct;
    }

    @Override
    public void execute(LogFoodInputData logFoodInputData) {
        final callUsdaApi usdaObject = new callUsdaApi("DEMO_KEY");
        final Food food = populateFromUsda.foodFromFirstResultUsda(logFoodInputData.getFood(), usdaObject);
        final LogFoodOutputData logFoodOutputData = new LogFoodOutputData(food.getDescription(),
                food.getMacroNutrients());
    }
}
