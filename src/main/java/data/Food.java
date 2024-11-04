package data;

import java.util.HashMap;

class Food {
    private String name;
    private float weight;
    private float calories;
    HashMap<String, Float> microNuitrients;
    HashMap<String, Float> macroNuitrients;

    public Food(String name, float weight, float calories) {
        this.name = name;
        this.weight = weight;
        this.calories = calories;
        this.microNuitrients = new HashMap<>();
        this.macroNuitrients = new HashMap<>();
    }
}