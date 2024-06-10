package data;

import data.Student;
import java.util.ArrayList;
import studentmanager.Inputter;

public class StudentList extends ArrayList<Student> {

    public StudentList() {
        super();
    }

    public Student searchCode(String code) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).code.equals(code)) {
                return this.get(i);
            }
        }
        return null;
    }

    public boolean checkNewCode(String code) {
        if (searchCode(code) != null) {
            return true;
        }
        return false;
    }

    public void addStudent() {
        System.out.println("ADD NEW STUDENT");
        String newCode = null, newName = null;
        int newMark = 0;
        boolean check = true;

        while (check == true) {
            newCode = Inputter.getACode("Input Student ID: ", "Please input again!", "^[Ss]\\d{3}");
            check = checkNewCode(newCode);
            newName = Inputter.getAString("Input name: ", "Please input again!");
            newMark = Inputter.getAnInteger("Input mark: ", "Please input a positive integer from 0 to 10!", 0, 10);

            if (check == true) {
                System.out.println("Student ID is duplicated!");
            } else {
                Student x = new Student(newCode, newName, newMark);
                this.add(x);
                System.out.println("Added successfully.");
            }
        }
    }

    public Student searchStudent() {
        String sCode = null;
        Student s = null;
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST. PLEASE ADD AT LEAST ONE STUDENT!");
        } else {
            while (s == null) {
                sCode = Inputter.getACode("Input Student ID: ", "Please input again!", "^[Ss]\\d{3}");
                s = this.searchCode(sCode);

                if (s == null) {
                    System.out.println("Not found. Input again, please!");
                } else {
                    System.out.println("Found " + sCode + ".");
                    s.showProfile();
                    return s;
                }
            }
        }
        return null;
    }

    public void updateStudent() {
        Student u = null;
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST. PLEASE ADD AT LEAST ONE STUDENT!");
        } else {

            System.out.println("Which one do you want to change info?");
            while (u == null) {
                u = this.searchStudent();

                if (u == null) {
                    System.out.println("Not found. Input again, please!");
                } else {
                    u = updateInfo(u);
                    System.out.println("Updated successfully.");
                    u.showProfile();
                }
            }
        }
    }

    public Student updateInfo(Student x) {
        int choice = 0;
        System.out.println("Which field do you want to change?");
        System.out.println("1. Student ID");
        System.out.println("2. Name");
        System.out.println("3. Mark");
        choice = Inputter.getAnInteger("(1..3) ", "Please choose 1..3!", 1, 3);

        switch (choice) {
            case 1: {
                String uCode = null;
                boolean check = true;

                while (check == true) {
                    uCode = Inputter.getACode("Input new ID: ", "Please input again!", "^[sS]\\d{3}");
                    check = checkNewCode(uCode);

                    if (check == true) {
                        System.out.println("Your new ID cannot be the same with your old ID!");
                    }
                }
                x.setCode(uCode);
                break;
            }

            case 2: {
                String uName = x.name;

                while (uName.equals(x.name)) {
                    uName = Inputter.getAString("Input new name: ", "Please input again!");
                    if (uName.equals(x.name)) {
                        System.out.println("Your new name cannot be the same with your old name!");
                    }
                }
                x.setName(uName);
                break;
            }

            case 3: {
                int uMark = x.mark;

                while (uMark == x.mark) {
                    uMark = Inputter.getAnInteger("Input new mark: ", "Please input again! (0 < mark < 10)", 0, 10);
                    if (uMark == x.mark) {
                        System.out.println("Your new mark cannot be the same with your old mark!");
                    }
                }
                x.setMark(uMark);
                break;
            }
        }
        return x;
    }

    public void removeStudent() {
        String rCode = null;
        Student rm = null;
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST. PLEASE ADD AT LEAST ONE STUDENT!");
        } else {
            while (rm == null) {
                rCode = Inputter.getACode("Input ID: ", "Please input again!", "^[sS]\\d{3}");
                rm = searchCode(rCode);

                if (rm == null) {
                    System.out.println("Not found. Input again, please!");
                } else {
                    this.remove(rm);
                    System.out.println("Removed successfully.");
                }
            }
        }
    }

    public void showList() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST. PLEASE ADD AT LEAST ONE STUDENT!");
        } else {
            System.out.println("STUDENT LIST");
            System.out.println("|CODE|        NAME        |MARK|");
            for (Student s : this) {
                s.showProfile();
            }
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }
}
