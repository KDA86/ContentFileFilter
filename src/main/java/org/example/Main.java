package org.example;

import org.example.exceptions.ManagerSaveException;
import org.example.managers.FilterManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ManagerSaveException, FileNotFoundException {
        filterManager(args);
    }

    protected static void filterManager(String[] args) throws ManagerSaveException, FileNotFoundException {
        FilterManager filterManager = new FilterManager();
        List<String> fileName = new ArrayList<>();
        List<String> existingFileName = List.of("floats.txt", "integers.txt", "strings.txt");
        String outPath = ".\\";
        String prefix = "";
        boolean fullStatistic = false;
        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-f")) {
                fullStatistic = true;
            } else if (args[i].contains("-a")) {
                fileName.addAll(existingFileName);
            } else if (args[i].contains("-o") && !args[i + 1].contains("-")) {
                outPath = args[i + 1];
            } else if (args[i].contains("-p") && !args[i + 1].contains(".txt")) {
                prefix = args[i + 1];
            } else if (args[i].contains("txt")) {
                fileName.add(args[i]);
            }
        }
        filterManager.filterManager(fullStatistic, outPath, prefix, fileName);
    }
}