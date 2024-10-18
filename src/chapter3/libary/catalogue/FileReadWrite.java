package chapter3.libary.catalogue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReadWrite {
    public static String readerFile(String filePath) throws IOException {
        String string = Files.readString(Paths.get(filePath));
        return string;
    }
}