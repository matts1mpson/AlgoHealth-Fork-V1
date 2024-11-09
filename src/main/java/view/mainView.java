package view;


import data.DayInfo;
import data.Food;

import javax.swing.*;

import static java.awt.Component.LEFT_ALIGNMENT;

public class mainView {

    private String calories = "0";
    private String protein = "0";
    private String carbs = "0";
    private String fat = "0";
    private Food food;

    public mainView(){

    }

    public void genMvGUI() {

        // Input fields and labels part.
        JLabel enterFood = new JLabel("Enter food:");
        JTextField foodInputField = new JTextField(15);
        JLabel enterAmountNumber = new JLabel("Enter weight number:");
        JTextField foodAmountField = new JTextField(15);
        JLabel enterAmountUnits = new JLabel("Enter weight units:");
        JTextField unitInputField = new JTextField(15);
        JButton submitButton = new JButton("Submit");

        // Macronutrient and calories values display.
        JLabel totalCalories = new JLabel("Total calories: " + calories);
        JLabel totalProtein = new JLabel("Total protein: " + protein);
        JLabel totalCarbs = new JLabel("Total carbohydrates: " + carbs);
        JLabel totalFat = new JLabel("Total fat: " + fat);

        // Input and submit panel.
        JPanel panel1 = new JPanel();
        panel1.add(enterFood);
        panel1.add(enterAmountNumber);
        panel1.add(foodInputField);
        panel1.add(enterAmountNumber);
        panel1.add(foodAmountField);
        panel1.add(enterAmountUnits);
        panel1.add(unitInputField);
        panel1.add(submitButton);

        // Macros panel.
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(totalCalories);
        panel2.add(totalProtein);
        panel2.add(totalCarbs);
        panel2.add(totalFat);

        //Food history panel.
        // In progress Nov 9 2:39pm.
        JPanel fhPanel = new JPanel();
        // loop through foods in Day.foodLog() and generate an entry.
        /*for (food: day.getFoodLog()) {
            JLabel food1 = new JLabel("food 1:" + food.getDescription() + food.getWeight() + food.getStandardUnit());
        }*/

        // Add to main panel.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(panel1);
        mainPanel.add(panel2);


        JFrame mainFrame = new JFrame("AlgoHealth");
        mainFrame.setSize(1000,500);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);



    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public static void main(String[] args) {
        mainView mV = new mainView();
        mV.genMvGUI();
        int i = 1;
    }

}
