package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class CSVParser {
    String delimeter;
    String filePath;

    public CSVParser(String path) {
        this.delimeter = ";";
        this.filePath = path;
    }

    public List<Map<String, String>> parse() {
        String line;
        List<Map<String, String>> storage = new ArrayList<>();;

        try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
            String headerLine = br.readLine();
            String[] headers = headerLine.split(this.delimeter);

            while((line = br.readLine()) != null) {
                String[] values = line.split(this.delimeter);
                Map<String, String> row = new LinkedHashMap<>();

                IntStream.range(0, values.length)
                        .forEach(i ->
                                row.put(headers[i], values[i]));

                System.out.println(row);
                storage.add(row);
            }

            System.out.println(storage);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return storage;
    }

    // public static void export(String path, List<Map<String, String>> list) {
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
    //         writer.write("[\n");

    //         for (int i = 0; i < list.size(); i++) {
    //             Map<String, String> row = list.get(i);
    //             writer.write("  {\n"); // start object

    //             int j = 0;
    //             for (Map.Entry<String, String> entry : row.entrySet()) {
    //                 String key = entry.getKey();
    //                 String value = entry.getValue();

    //                 // Escape quotes in values
    //                 value = value.replace("\"", "\\\"");

    //                 writer.write(String.format("    \"%s\": \"%s\"%s%n",
    //                         key, value, (j < row.size() - 1 ? "," : "")));
    //                 j++;
    //             }

    //             writer.write("  }" + (i < list.size() - 1 ? "," : "") + "\n"); // end object
    //         }

    //         writer.write("]"); // end JSON array
    //         System.out.println("JSON written to: " + path);

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
