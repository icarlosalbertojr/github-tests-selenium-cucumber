package com.icarlosalbertojr.githubtestsautomation.utils;

import com.icarlosalbertojr.githubtestsautomation.login.LoginModel;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GetLoginDataFromCSV {

    private static final String FILE_PATH = "./login.csv";

    public static LoginModel getData() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .build();
            String[] data = csvReader.readAll().get(0);
            return new LoginModel(data[0], data[1], data[2]);
        } catch (IOException exception) {
            return null;
        }
    }

}
