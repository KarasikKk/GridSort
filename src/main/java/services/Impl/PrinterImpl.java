package services.Impl;

import services.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PrinterImpl implements Printer {

    @Override
    public void print(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
