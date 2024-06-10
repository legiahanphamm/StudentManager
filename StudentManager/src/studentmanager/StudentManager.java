package studentmanager;

import data.StudentList;
import ui.Menu;

public class StudentManager {

    public static void main(String[] args) {
        StudentList list = new StudentList();
        int choice = 0;
        do {
            Menu.printMenu();
            choice = Menu.getAChoice();

            switch (choice) {
                case 1: {
                    list.addStudent();
                    break;
                }

                case 2: {
                    list.searchStudent();
                    break;
                }

                case 3: {
                    list.updateStudent();
                    break;
                }

                case 4: {
                    list.removeStudent();
                    break;
                }

                case 5: {
                    list.showList();
                    break;
                }

                case 6: {
                    System.out.println("THANK YOU. SEE YOU AGAIN!");
                    break;
                }
            }
        } while (choice != 6);
    }
}
