package org.example;

import java.util.List;

public class ListComparator {
    public static String compareLists(List<Double> list1, List<Double> list2) {
        double average1 = calculateAverage(list1);
        double average2 = calculateAverage(list2);

        if (average1 > average2) {
            return "Первый список имеет большее среднее значение";
        } else if (average1 < average2) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }

    private static double calculateAverage(List<Double> list) {
        double sum = 0;

        for (Double number : list) {
            sum += number;
        }

        return sum / list.size();
    }
}
