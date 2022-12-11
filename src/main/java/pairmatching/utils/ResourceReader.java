package pairmatching.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceReader {

    public static List<String> readResource(String name) throws IOException {
        URL resource = ResourceReader.class.getClassLoader().getResource(name);
        assert resource != null;

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(resource.openStream()));

        return bufferedReader.lines().collect(Collectors.toList());
    }

}
