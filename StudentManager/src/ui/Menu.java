package ui;

import studentmanager.Inputter;

public class Menu {
    public static void printMenu() {
        System.out.println("1. Add new student");
        System.out.println("2. Search a student based in his/her code");
        System.out.println("3. Update name and mark of a student based on his/her code");
        System.out.println("4. Remove a student based on his/her code");
        System.out.println("5. List all students");
        System.out.println("6. Quit");
    }
    
    public static int getAChoice() {
        return Inputter.getAnInteger("Choose option from 1 to 6: ", "Please choose again!", 1, 6);
    }
}
