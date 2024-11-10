package interface_adapter.get_recommendations;

import view.recommendationsView;

import java.util.ArrayList;

import static interface_adapter.get_recommendations.recViewModel.callgenRecView;


public class recPresenter {

    public static void execute(double calories, double protein, double carbs, double fat, double percent_carbs,
                               double percent_cals, double percent_prot, double percent_fat) {
        // update the recommendations view
        // call ViewModel to display new recommendations view as "pop-up"
        ArrayList<String> temp1 = new ArrayList<>();
        temp1.add(String.valueOf(calories));
        temp1.add("Kcal");

        ArrayList<String> temp2 = new ArrayList<>();
        temp2.add(String.valueOf(protein));
        temp2.add("g");

        ArrayList<String> temp3 = new ArrayList<>();
        temp3.add(String.valueOf(carbs));
        temp3.add("g");

        ArrayList<String> temp4 = new ArrayList<>();
        temp4.add(String.valueOf(fat));
        temp4.add("g");

        recommendationsView recView = new recommendationsView();
        recView.setPercent_cals(percent_cals);
        recView.setPercent_carbs(percent_carbs);
        recView.setPercent_prot(percent_prot);
        recView.setPercent_fat(percent_fat);
        callgenRecView(temp1, temp2, temp3, temp4, String.valueOf(percent_cals), String.valueOf(percent_prot),
                String.valueOf(percent_carbs), String.valueOf(percent_fat));


    }
}
