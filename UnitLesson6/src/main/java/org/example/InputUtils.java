package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtils {
    public static List<Double> readList(Scanner scanner) {
        List<Double> list = new ArrayList<>();
        String[] elements = scanner.nextLine().split(" ");

        for (String element : elements) {
            list.add(Double.parseDouble(element));
        }

        return list;
    }
}
