package org.example.managers;

import org.example.exceptions.ManagerSaveException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterManager {

    Calculator calculator = new Calculator();

    public void filterManager(boolean fullStatistic, String outPath, String prefix, List<String> fileName) throws ManagerSaveException, FileNotFoundException {

        List<String> arrays = loadFromFile(fileName);
        List<String> strings = new ArrayList<>();
        List<Long> integers = new ArrayList<>();
        List<Float> floats = new ArrayList<>();

        for (String array : arrays) {
            if (array.chars().allMatch(Character::isDigit)) {
                integers.add(Long.valueOf(array));
            } else if (array.contains(".")) {
                floats.add(Float.valueOf(array));
            } else {
                strings.add(array);
            }
        }
        if (!strings.isEmpty()) {
            createAndSaveToStrings(outPath, prefix, strings);
        }
        if (!integers.isEmpty()) {
            createAndSaveToIntegers(outPath, prefix, integers);
        }
        if (!floats.isEmpty()) {
            createAndSaveToFloats(outPath, prefix, floats);
        }
        printStatistic(fullStatistic, strings, integers, floats);
    }


    public List<String> loadFromFile(List<String> fileName) throws FileNotFoundException {
        List<String> arrays = new ArrayList<>();
        for (String name : fileName) {
            File file = new File(".\\" + name);
            System.out.println(file.getAbsolutePath());
            if (file.isFile()) {
                Scanner fileReader = new Scanner(new File(".\\" + name));
                while (fileReader.hasNext()) {
                    String line = fileReader.nextLine();
                    if (!line.isBlank()) {
                        arrays.add(line);
                    }
                }
            } else {
                System.out.println("Файл " + name + " не найден");
            }
        }
        return arrays;
    }

    public void createAndSaveToStrings(String outPath, String prefix, List<String> strings) throws ManagerSaveException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + prefix + "strings.txt"))) {
            for (String array : strings) {
                bufferedWriter.write(array);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ManagerSaveException("Возникла ошибка при сохранении файла");
        }
    }

    public void createAndSaveToFloats(String outPath, String prefix, List<Float> floats) throws ManagerSaveException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + prefix + "floats.txt"))) {
            for (Float array : floats) {
                bufferedWriter.write(array.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ManagerSaveException("Возникла ошибка при сохранении файла");
        }
    }

    public void createAndSaveToIntegers(String outPath, String prefix, List<Long> integers) throws ManagerSaveException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + prefix + "integers.txt"))) {
            for (Long array : integers) {
                bufferedWriter.write(array.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ManagerSaveException("Возникла ошибка при сохранении файла");
        }
    }

    private void printStatistic(boolean fullStatistic, List<String> strings, List<Long> integers, List<Float> floats) {
        if (fullStatistic) {
            System.out.println("Количество элементов в strings: " + strings.size());
            System.out.println("Самая короткая строка: " + calculator.countingMinStringLength(strings) + " символа(ов)");
            System.out.println("Самая длинная строка: " + calculator.countingMaxStringLength(strings) + " символа(ов)");

            System.out.println("Количество элементов в integers: " + integers.size());
            System.out.println("Миниальное значение в integers: " + calculator.countingMinIntValue(integers));
            System.out.println("Максимальное значение в integers: " + calculator.countingMaxIntValue(integers));
            System.out.println("Среднее значение в integers: " + calculator.countingMidIntValue(integers));
            System.out.println("Сумма значений в integers: " + calculator.countingSumIntValue(integers));

            System.out.println("Количество элементов в floats: " + floats.size());
            System.out.println("Миниальное значение в floats: " + calculator.countingMinFloatValue(floats));
            System.out.println("Максимальное значение в floats: " + calculator.countingMaxFloatValue(floats));
            System.out.println("Среднее значение в floats: " + calculator.countingMidFloatValue(floats));
            System.out.println("Сумма значений в floats: " + calculator.countingSumFloatValue(floats));
        } else {
            System.out.println("Количество элементов в strings: " + strings.size());
            System.out.println("Количество элементов в integers: " + integers.size());
            System.out.println("Количество элементов в floats: " + floats.size());
        }
    }


}