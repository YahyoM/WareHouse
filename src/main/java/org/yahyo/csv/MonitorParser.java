package org.yahyo.csv;

import org.yahyo.entity.Monitor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitorParser implements CsvLineParser<Monitor> {

    public static Monitor parseCSVLine(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        float price = Float.parseFloat(parts[1].trim());
        String brand = parts[2].trim();
        String durability = parts[3].trim();
        String resolution = parts[4].trim();
        return new Monitor(id, price, brand, durability, resolution);
    }

    public static List<Monitor> readMonitorsFromCSV(String filename) {
        List<Monitor> monitors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                monitors.add(parseCSVLine(line));
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return monitors;
    }

    @Override
    public List<Monitor> readData(String path) {
        return readMonitorsFromCSV(path);
    }
}
