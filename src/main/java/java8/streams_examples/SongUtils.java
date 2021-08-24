package java8.streams_examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class SongUtils {
    public static int countWordsInSong(String filename) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            return (int) stream.flatMap(str -> Arrays.stream(str.split(" ")))
                    .count();
        } catch (IOException e) {
            System.out.println("IOException! " + e);
            return 0;
        }
    }
}
