package services.Impl;

import services.Sorter;

import java.util.Comparator;
import java.util.List;

public class SorterImpl implements Sorter {

    @Override
    public void sort(Comparator<String> comparator, List<String> grid) {
        grid.sort(comparator);
    }

}
