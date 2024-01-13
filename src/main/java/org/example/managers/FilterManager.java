package org.example.managers;

import org.example.exceptions.ManagerSaveException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterManager {
    public void filterManager(boolean fullStatistic, String outPath, String prefix, List<String> fileName) throws ManagerSaveException, FileNotFoundException {

        List<String> arrays = load(fileName);
        List<String> strings = new ArrayList<>();
        List<String> integers = new ArrayList<>();
        List<String> floats = new ArrayList<>();

        for (String array : arrays) {
            if (array.chars().allMatch(Character::isDigit)) {
                integers.add(array);
            } else if (array.contains(".")) {
                floats.add(array);
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



    public List<String> load(List<String> fileName) throws FileNotFoundException {
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

    public void createAndSaveToFloats(String outPath, String prefix, List<String> floats) throws ManagerSaveException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + prefix + "floats.txt"))) {
            for (String array : floats) {
                bufferedWriter.write(array);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ManagerSaveException("Возникла ошибка при сохранении файла");
        }
    }

    public void createAndSaveToIntegers(String outPath, String prefix, List<String> integers) throws ManagerSaveException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outPath + prefix + "integers.txt"))) {
            for (String array : integers) {
                bufferedWriter.write(array);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new ManagerSaveException("Возникла ошибка при сохранении файла");
        }
    }

    private void printStatistic(boolean fullStatistic, List<String> strings, List<String> integers, List<String> floats) {
        if (fullStatistic) {
            System.out.println("Количество элементов в strings: " + strings.size());
            System.out.println("Самая короткая строка: " + countingMinStringLength(strings) + " символа(ов)");
            System.out.println("Самая длинная строка: " + countingMaxStringLength(strings) + " символа(ов)");

            System.out.println("Количество элементов в integers: " + integers.size());
            System.out.println("Миниальное значение в integers: " + countingMinValue(integers));
            System.out.println("Максимальное значение в integers: " + countingMaxValue(integers));
            System.out.println("Среднее значение в integers: " + countingMidValue(integers));
            System.out.println("Сумма значений в integers: " + countingSumValue(integers));

            System.out.println("Количество элементов в floats: " + floats.size());
            System.out.println("Миниальное значение в floats: " + countingMinValue(floats));
            System.out.println("Максимальное значение в floats: " + countingMaxValue(floats));
            System.out.println("Среднее значение в floats: " + countingMidValue(floats));
            System.out.println("Сумма значений в floats: " + countingSumValue(floats));
        } else {
            System.out.println("Количество элементов в strings: " + strings.size());
            System.out.println("Количество элементов в integers: " + integers.size());
            System.out.println("Количество элементов в floats: " + floats.size());
        }
    }

    public int countingMaxStringLength(List<String> strings){
        int maxLength = 0;
        for (String string: strings){
            if(string.length() > maxLength){
                maxLength = string.length();
            }
        }
        return maxLength;
    }

    public int countingMinStringLength(List<String> strings){
        int maxLength = 2;
        for (String string: strings){
            if(string.length() < maxLength){
                maxLength = string.length();
            }
        }
        return maxLength;
    }

    public double countingMinValue(List<String> values){
        double minValue = Double.MAX_VALUE;
        for (String value: values){
            if(Double.parseDouble(value) < minValue){
                minValue = Double.parseDouble(value);
            }
        }
        return minValue;
    }

    public double countingMaxValue(List<String> values){
        double maxValue = Double.MIN_VALUE;
        for (String value: values){
            if(Double.parseDouble(value) > maxValue){
                maxValue = Double.parseDouble(value);
            }
        }
        return maxValue;
    }

    public double countingMidValue(List<String> values){
        double sumValue = 0.0f;
        for (String value: values){
            sumValue = sumValue + Double.parseDouble(value);
            }
        return sumValue / values.size();
    }

    public double countingSumValue(List<String> values){
        double sumValue = 0.0f;
        for (String value: values){
            sumValue = sumValue + Double.parseDouble(value);
        }
        return sumValue;
    }
}