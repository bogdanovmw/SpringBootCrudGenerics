package com.example.Test.utils;

import com.example.Test.model.Clients;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UtilFiles {
    private static final int[] array = new Random().ints(20, 1, 1000).toArray();
    private static int id = 1;

    public static List<Clients> readFile() {
        List<Clients> clients = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("data.csv").getFile()))) {
            for (String[] s : reader.readAll()) {
                Clients client = Clients.builder()
                            .id(Integer.parseInt(s[0]))
                            .firstname(s[1])
                            .lastname(s[2])
                            .email(s[3])
                            .age(Integer.parseInt(s[4]))
                            .dateOfBirth(s[5])
                            .city(s[6])
                            .country(s[7])
                        .build();
                clients.add(client);
            }
        } catch (IOException | CsvException e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }

    public static List<Clients> getRandom20Elements() {
        List<Clients> clients = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("1000data.csv").getFile()))) {
            for (String[] s : reader.readAll()) {
                for (int i = 0; i < array.length; i++ ) {
                    if (Integer.parseInt(s[0]) == array[i]) {
                        Clients client = Clients.builder()
                                .id(id)
                                .firstname(s[1])
                                .lastname(s[2])
                                .email(s[3])
                                .age(Integer.parseInt(s[4]))
                                .dateOfBirth(s[5])
                                .city(s[6])
                                .country(s[7])
                            .build();
                        clients.add(client);
                        id++;
                    }
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
