
import comparators.GridComparator;
import services.ApplicationRunner;
import services.Impl.FileReaderImpl;
import services.Impl.FileWriterImpl;
import services.Impl.PrinterImpl;
import services.Impl.SorterImpl;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer,String> menuOptions = new HashMap<>();
        menuOptions.put(1,"Print input file to console.");
        menuOptions.put(2,"Start sorting");
        menuOptions.put(3,"Print result to console");
        menuOptions.put(4,"Exit");

        new ApplicationRunner(menuOptions,new SorterImpl(),new FileReaderImpl(),
                new GridComparator(),new FileWriterImpl(),new PrinterImpl()).run();
    }
}