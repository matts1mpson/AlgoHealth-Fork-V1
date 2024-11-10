package use_case.get_recs;

import interface_adapter.get_recommendations.recPresenter;

public class DvRecsInteractor {
    // Take state information from main view, get it from controller,
    // update the recommendations view.

    // constants for DVs based on https://www.canada.ca/en/health-canada/services/food-nutrition/
    // healthy-eating/dietary-reference-intakes/tables/reference-values-macronutrients.html
    // and assumed body weight of 80kg and age 19-30 and assumed recommended calories 2000 Kcal.
    // fat intake is just a randomly selected number right now as there is no indication of its value in the link.

    final static double DVcals = 2000;
    final static double DVprot = 80 * 0.66;
    final static double DVcarbs = 100;
    final static double DVfat = 200 ;
    /**
     *
     * @param calories state info from view
     * @param protein state info from view
     * @param carbs state info from view
     * @param fat state info from view
     */
    public static void execute(double calories, double protein, double carbs,
                               double fat) {
        // get the percent pass to the presenter to update the recommendations view.
        double percent_cals = (calories / DVcals) * 100;
        double percent_prot = (protein / DVprot) * 100;
        double percent_carbs = (protein / DVcarbs) * 100;
        double percent_fat = (protein / DVfat) * 100;

        recPresenter.execute(calories, protein, carbs, fat, percent_cals, percent_carbs, percent_prot, percent_fat);

    }
}
