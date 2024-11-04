package data;

import java.util.List;

class AccountInfo {
    private int age;
    private float height;
    private float weight;
    private String diet;
    private String goal;
    private String username;
    private String password;
    private List<DayInfo> days;
    private List<Food> dietaryRestrictions;

    public AccountInfo(int age, float height, float weight, String diet, String goal,
                       String username, String password) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.diet = diet;
        this.goal = goal;
        this.username = username;
        this.password = password;
    }

}