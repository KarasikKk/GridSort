package comparators;

import java.util.Comparator;
import java.util.regex.Pattern;

public class GridComparator implements Comparator<String> {
    private final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public int compare(String line1, String line2) {
        int columnNumber = 0;
        String[] firstLine = getSplittingString(line1);
        String[] secondLine = getSplittingString(line2);

        int numberOfColumn = getColumnNumber(line1);
        while (columnNumber < numberOfColumn) {
            String s1 = takeElement(firstLine[columnNumber]);
            String s2 = takeElement(secondLine[columnNumber]);

            if (s1.compareTo(s2) != 0) {

                if (isNumeric(s1) && isNumeric(s2)) {
                    return digitCompare(s1, s2);
                } else {
                    return compareDifElem(s1, s2);
                }
            } else {
                columnNumber++;
            }
        }
        return 1;
    }

    private String[] getSplittingString(String line){
        return line.replaceAll("\t"," \t ").split("\t");
    }

    private String takeElement(String elem){
        return elem.replaceAll("\\s+", "");
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    private int digitCompare(String firstElem, String secondElem) {
        Double firstGrid = Double.parseDouble(firstElem);
        Double secondGrid = Double.parseDouble(secondElem);
        return firstGrid.compareTo(secondGrid);
    }

    private int compareDifElem(String firstElem, String secondElem) {
        if (isNumeric(firstElem)) {
            return -1;
        } else if (isNumeric(secondElem)) {
            return 1;
        } else {
            return firstElem.compareTo(secondElem);
        }
    }
    private int getColumnNumber(String line){
        return (line.length() - line.replace("\t", "").length()) + 1;
    }
}