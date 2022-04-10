package services;

import java.util.*;

public class ApplicationRunner {

    Map<Integer,String> menuOptions;
    private static final String INPUT_FILE_PATH = "in.txt";
    private static final String OUTPUT_FILE_PATH = "out.txt";
    private final Sorter sorter;
    private final Reader reader;
    private final Writer writer;
    private final Comparator comparator;
    private final Printer printer;


    public ApplicationRunner(Map<Integer,String> menuOptions,Sorter sorter,Reader reader,
                             Comparator comparator,Writer writer,Printer printer) {
        this.menuOptions = menuOptions;
        this.sorter = sorter;
        this.reader = reader;
        this.comparator = comparator;
        this.writer = writer;
        this.printer = printer;
    }

    public void run(){

        int option = 0;
        while (option!=4){
            System.out.println();
            printMenu();
            System.out.print("Choose your option : ");
            Scanner in = new Scanner(System.in);
            try {
                option = in.nextInt();
                if (checkIfExistMenuOption(option)){
                    startExecution(option);
                }else {
                    System.out.println("Please enter an integer value from menu.\n");
                }
            } catch (InputMismatchException ex){
                System.out.println("Please enter an integer value from menu.\n");
                in.next();
            } catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again.\n");
                in.next();
            }
        }
    }

    private void startExecution(int menuOption){
        switch (menuOption) {
            case 1:
                System.out.println("You choose: " + menuOptions.get(menuOption) + "\n");
                printer.print(INPUT_FILE_PATH);
                break;
            case 2:
                System.out.println("You choose: " + menuOptions.get(menuOption) + "\n");
                sortAndWriteToFile();
                break;
            case 3:
                System.out.println("You choose: " + menuOptions.get(menuOption) + "\n");
                printer.print(OUTPUT_FILE_PATH);
                break;
            case 4:
                break;
        }
    }


    private boolean checkIfExistMenuOption(int number){
        return menuOptions.containsKey(number);
    }

    private void printMenu(){
        for(Map.Entry<Integer, String> pair : menuOptions.entrySet())
        {
            Integer key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + ". " + value);
        }
    }

    private void sortAndWriteToFile(){
        List<String> lines = reader.read(INPUT_FILE_PATH);
        sorter.sort(comparator,lines);
        writer.write(lines,OUTPUT_FILE_PATH);
    }
}
