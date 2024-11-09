package api;

import data.Food;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class populateFromUsda {

    public static Food foodFromFirstResultUsda(String food, callUsdaApi usdaObj) {
            JSONObject firstResult = usdaObj.callUsdaSearch(food);
            String standardUnit = firstResult.getString("servingSizeUnit");
            String description = firstResult.getString("description");
            JSONArray fresNutrients = firstResult.getJSONArray("foodNutrients");
            // do some initial instance variable assignment for the Food object we're creating.
            // foodTbc is short for foodToBeCreated.
            Food foodTbc = new Food();
            foodTbc.setStandardUnit(standardUnit);
            foodTbc.setDescription(description);
            // Loop through until we've found protein, carbs, fat, and calories amounts per 100 standard units.
            // Record the units of these as well.
            int i = 0;
            int j = 0;
            HashMap<String, HashMap<String, Object>> macros = new HashMap<>();
            while (i < fresNutrients.length() && j < 4) {
                String nutrientName = fresNutrients.getJSONObject(i).getString("nutrientName");
                if (nutrientName.equals("Protein")) {
                    HashMap<String, Object> temp = tempWithAmountAndUnits(standardUnit, fresNutrients, i);
                    macros.put("Protein", temp);
                    i += 1;
                    j += 1;
                }
                else if (nutrientName.equals("Carbohydrate, by difference")) {
                    HashMap<String, Object> temp = tempWithAmountAndUnits(standardUnit, fresNutrients, i);
                    macros.put("Carbohydrate", temp);
                i += 1;
                j += 1;
                }
                else if (nutrientName.equals("Energy")) {
                    HashMap<String, Object> temp = tempWithAmountAndUnits(standardUnit, fresNutrients, i);
                    foodTbc.setCalories(temp);
                i += 1;
                j += 1;
                }
                else if (nutrientName.equals("Total lipid (fat)")) {
                    HashMap<String, Object> temp = tempWithAmountAndUnits(standardUnit, fresNutrients, i);
                    macros.put("Fat", temp);
                    i += 1;
                    j += 1;
                }
                else {
                    i += 1;
                }
            }
            foodTbc.setMacroNutrients(macros);
            return foodTbc;
    }

    @NotNull
    private static HashMap<String, Object> tempWithAmountAndUnits(String standardUnit, JSONArray fresNutrients, int i) {
        HashMap<String, Object> temp = new HashMap<>();
        temp.put("amount per 100" + standardUnit, fresNutrients.getJSONObject(i).getInt("value"));
        temp.put("unitName", fresNutrients.getJSONObject(i).getString("unitName"));
        return temp;
    }

    public static void main(String[] args) {
        // Informal test for now. "DEMO_KEY" should work, but you can replace it with your USDA API key.
        // Place breakpoint and debug. Have a look at result. It is a food entity with protein, carbs, fat,
        // and calories per 100ml. These values were pulled from the USDA API.
        String apiKey = "DEMO_KEY";
        callUsdaApi usdaObj = new callUsdaApi(apiKey);
        Food result = foodFromFirstResultUsda("whole milk", usdaObj);
        String breakpoint1 = "break here";
    }
}

