package services.Impl;

import exceptions.EmptyFileException;
import exceptions.EmptyPathException;
import services.Reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements Reader {

    @Override
    public List<String> read(String path) {

        if (checkPath(path)) {
            List<String> lines = new ArrayList<>();
            try (Stream<String> lineStream = Files.lines(Paths.get(path))) {
                lines = lineStream.collect(Collectors.toList());
                if (lines.size() == 0) {
                    throw new EmptyFileException(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        } else {
            throw new EmptyPathException();
        }
    }

    private boolean checkPath(String path){
        return path.length() > 0;
    }
}
