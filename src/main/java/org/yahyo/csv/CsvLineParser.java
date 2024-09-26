package org.yahyo.csv;

import java.util.List;

public interface CsvLineParser<A> {
    List<A> readData(String fileName);
}
