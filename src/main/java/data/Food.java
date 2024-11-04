package data;

import java.util.HashMap;

class Food {
    private final String name;
    private final float weight;
    private final float calories;
    private final HashMap<String, Float> microNuitrients;
    private final HashMap<String, Float> macroNuitrients;

    public Food(String name, float weight, float calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.microNuitrients = new HashMap<>();
        this.macroNuitrients = new HashMap<>();
    }
}