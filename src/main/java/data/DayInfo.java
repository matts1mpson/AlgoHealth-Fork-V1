package data;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

class DayInfo {
    LocalDateTime date;
    float totalCalories;
    List<Food> foodLog;

    public DayInfo(LocalDateTime date) {
        this.date = date;
        totalCalories = 0;
        foodLog = new ArrayList<>();
    }
}