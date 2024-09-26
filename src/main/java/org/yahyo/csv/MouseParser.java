package org.yahyo.csv;

import org.yahyo.entity.Mouse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MouseParser implements CsvLineParser<Mouse> {

    public static Mouse parseCSVLine(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        float price = Float.parseFloat(parts[1].trim());
        String brand = parts[2].trim();
        String durability = parts[3].trim();
        String connectivity = parts[4].trim();
        return new Mouse(id, price, brand, durability, connectivity);
    }

    public static List<Mouse> readMousesFromCSV(String filename) {
        List<Mouse> mouses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // Skip the header line
            String line;
            while ((line = br.readLine()) != null) {
                mouses.add(parseCSVLine(line));
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return mouses;
    }

    @Override
    public List<Mouse> readData(String path) {
        return readMousesFromCSV(path);
    }
}

