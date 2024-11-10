package interface_adapter.get_recommendations;

import use_case.get_recs.DvRecsInteractor;

import java.util.ArrayList;

public class getRecsController {
    // Take state information from mainView, the total carbs, protein, fat, calories, and pass to Interactor.
    public static void execute(ArrayList<Object> calories, ArrayList<Object> protein, ArrayList<Object> carbs,
                               ArrayList<Object> fat) {
        DvRecsInteractor.execute(Double.valueOf((String) calories.get(0)), Double.valueOf((String) protein
                .get(0)),Double.valueOf((String) carbs.get(0)), Double.valueOf((String) fat.get(0)));
    }
}
