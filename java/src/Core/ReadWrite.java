package Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadWrite {
    public static void run() {
        Path inputPath = Path.of("src/Core/data/input.txt");
        var inputFile = new File(inputPath.toUri());

        try (var in = new FileInputStream(inputFile)) {
            Files.copy(in, Path.of("src/Core/data/output.txt"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
