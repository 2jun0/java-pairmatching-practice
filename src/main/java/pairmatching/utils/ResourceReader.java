package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceReader {

    public static List<String> readResource(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/" + name));

        return bufferedReader.lines().collect(Collectors.toList());
    }

}
