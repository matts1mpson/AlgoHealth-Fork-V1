package interface_adapter.get_recommendations;

import java.util.ArrayList;

import static view.recommendationsView.genRecView;

public class recViewModel {

    public static void callgenRecView(ArrayList<String> calories, ArrayList<String> protein, ArrayList<String> carbs,
                                      ArrayList<String> fat, String percent_cals, String percent_prot,
                                      String percent_carbs, String percent_fat) {
        genRecView(calories, protein, carbs,
                fat, percent_cals, percent_prot, percent_carbs,
                percent_fat);
    }

}
