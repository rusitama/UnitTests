package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListComparatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите элементы первого списка (через пробел): ");
        List<Double> list1 = InputUtils.readList(scanner);

        System.out.print("Введите элементы второго списка (через пробел): ");
        List<Double> list2 = InputUtils.readList(scanner);

        String result = ListComparator.compareLists(list1, list2);
        System.out.println(result);

        // Закрытие Scanner
        scanner.close();
    }
}


