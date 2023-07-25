package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
    private ArrayList<Double> numbers;

    public Excel(ArrayList<Double> numbers) {
        this.numbers = numbers;
    }

    public Excel(String input) {
        // Split the input string into an array of number strings
        String[] strNumArray = input.split(",");
        // Convert the array into a list and remove any leading/trailing spaces
        List<String> strNumList = Arrays.asList(strNumArray);
        ArrayList<Double> strNumArrayList = new ArrayList<>();
        // Convert each string number to a double and add it to the ArrayList
        strNumList.forEach(str -> strNumArrayList.add(Double.parseDouble(str.trim())));

        this.numbers = strNumArrayList;
    }

    public double findTotal() {
        double total = 0;
        // Calculate the sum of all numbers in the list
        for (double number : numbers) {
            total += number;
        }
        return total;
    }

    public double findAvg() {
        double total = findTotal();
        // Calculate the average by dividing the total by the number of elements
        return total / numbers.size();
    }

    public double findMax() {
        double maximum = Double.MIN_VALUE;
        // Find the maximum number in the list
        for (double number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }

    public double findMin() {
        double minimum = Double.MAX_VALUE;
        // Find the minimum number in the list
        for (double number : numbers) {
            if (number < minimum) {
                minimum = number;
            }
        }
        return minimum;
    }
}
