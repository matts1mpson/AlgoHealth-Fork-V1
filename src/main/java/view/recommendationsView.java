package view;

import data.Food;

import javax.swing.*;

import java.util.ArrayList;

public class recommendationsView {

    // for all instance attributes the item at 0 is the amount, and the item at 1 is the unit.
    private ArrayList<String> calories;
    private ArrayList<String> protein;
    private ArrayList<String> carbs;
    private ArrayList<String> fat;
    private Food food;
    private double percent_cals;
    private double percent_prot;
    private double percent_carbs;
    private double percent_fat;


    public recommendationsView() {

    }

    public static void genRecView(ArrayList<String> calories, ArrayList<String> protein, ArrayList<String> carbs,
                      ArrayList<String> fat, String percent_cals, String percent_prot, String percent_carbs,
                                  String percent_fat) {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        JLabel dv1 = new JLabel(calories.get(0) + calories.get(1) + " is " +
                percent_cals + "% of the recommended Daily Value of calories.");
        JLabel dv2 = new JLabel(protein.get(0) + protein.get(1) + " is "
                + percent_prot + "% of the recommended Daily Value of protein.");
        JLabel dv3 = new JLabel(carbs.get(0) + carbs.get(1) + " is "
                + percent_carbs + "% of the recommended Daily Value of carbohydrates.");
        JLabel dv4 = new JLabel(fat.get(0) + fat.get(1) + " is "
                + percent_fat + "% of the recommended Daily Value of fat.");
        panel1.add(dv1);
        panel1.add(dv2);
        panel1.add(dv3);
        panel1.add(dv4);

        JFrame mainFrame = new JFrame("Daily Value Recommendations");
        mainFrame.setSize(1000,500);
        mainFrame.setContentPane(panel1);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        ArrayList<String> cals = new ArrayList<>();
        cals.add("1");
        cals.add("g");
        ArrayList<String> prot = new ArrayList<>();
        prot.add("1");
        prot.add("g");
        ArrayList<String> carbs = new ArrayList<>();
        carbs.add("1");
        carbs.add("g");
        ArrayList<String> fat = new ArrayList<>();
        fat.add("1");
        fat.add("g");
        genRecView(cals, prot, carbs, fat, "20", "10", "5", "6");
    }

    public ArrayList<String> getCalories() {
        return calories;
    }

    public void setCalories(ArrayList<String> calories) {
        this.calories = calories;
    }

    public ArrayList<String> getProtein() {
        return protein;
    }

    public void setProtein(ArrayList<String> protein) {
        this.protein = protein;
    }

    public ArrayList<String> getCarbs() {
        return carbs;
    }

    public void setCarbs(ArrayList<String> carbs) {
        this.carbs = carbs;
    }

    public ArrayList<String> getFat() {
        return fat;
    }

    public void setFat(ArrayList<String> fat) {
        this.fat = fat;
    }

    public double getPercent_cals() {
        return percent_cals;
    }

    public void setPercent_cals(double percent_cals) {
        this.percent_cals = percent_cals;
    }

    public double getPercent_prot() {
        return percent_prot;
    }

    public void setPercent_prot(double percent_prot) {
        this.percent_prot = percent_prot;
    }

    public double getPercent_carbs() {
        return percent_carbs;
    }

    public void setPercent_carbs(double percent_carbs) {
        this.percent_carbs = percent_carbs;
    }

    public double getPercent_fat() {
        return percent_fat;
    }

    public void setPercent_fat(double percent_fat) {
        this.percent_fat = percent_fat;
    }
}
