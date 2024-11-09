package api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class callUsdaApi {
    public String apiKey;

    public callUsdaApi(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     *
     * @param food The food query we are searching the USDA database with.
     * @return The first result of the USDA database search with <code>food</code> as the query.
     */
    public JSONObject callUsdaSearch(String food) {
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url("https://api.nal.usda.gov/fdc/v1/foods/search?api_key=" + apiKey + "&query=" + food)
                .build();

        try {
            final Response response = client.newCall(request).execute();
            final JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray foodsArray = responseBody.getJSONArray("foods");
            // Consider modifying function to use the Strategy Design Pattern. At current, the function uses the
            // algo/strategy of returning the first result corresponding to the query. A better algo would return a
            // list of results that ultimately would be displayed to the user. Then the user could select the best
            // match from the list. Nov 8th, 24 (Matt).
            JSONObject firstResult = (JSONObject) foodsArray.get(0);
            return firstResult;
        } catch (IOException | JSONException event) {
            throw new RuntimeException(event);
        }
    }
}
// Citation: lab-4 code https://github.com/CSC207-2024F-UofT/lab-4
