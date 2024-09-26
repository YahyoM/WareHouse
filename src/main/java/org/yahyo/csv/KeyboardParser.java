package org.yahyo.csv;

import org.yahyo.entity.Keyboard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeyboardParser implements CsvLineParser<Keyboard> {

    public static Keyboard parseCSVLine(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0].trim());
        float price = Float.parseFloat(parts[1].trim());
        String brand = parts[2].trim();
        String durability = parts[3].trim();
        String layout = parts[4].trim();
        return new Keyboard(id, price, brand, durability, layout);
    }

    public static List<Keyboard> readKeyboardsFromCSV(String filename) {
        List<Keyboard> keyboards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                keyboards.add(parseCSVLine(line));
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return keyboards;
    }

    @Override
    public List<Keyboard> readData(String path) {
        return readKeyboardsFromCSV(path);
    }
}

