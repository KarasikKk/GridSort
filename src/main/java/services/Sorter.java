package services;

import java.util.Comparator;
import java.util.List;

public interface Sorter {
    void sort(Comparator<String> comparator,List<String> grid);
}
