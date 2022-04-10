package services.Impl;

import exceptions.EmptyPathException;
import services.Writer;

import java.io.*;
import java.util.List;

public class FileWriterImpl implements Writer {

    @Override
    public void write(List<String> listOfGrids,String path) {

        if (path.length() > 0) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String grid : listOfGrids) {
                writer.write(grid + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }else {
            throw new EmptyPathException();
        }
    }
}
