package studentmanager;

import java.util.Scanner;

public class Inputter {

    public static Scanner sc = new Scanner(System.in);

    public static int getAnInteger(String msg, String err, int min, int max) {
        int a = 0;

        if (min > max) {
            int t = min;
            min = max;
            max = t;
        }

        while (true) {
            try {
                System.out.print(msg);
                a = Integer.parseInt(sc.nextLine());

                if (a < min || a > max) {
                    throw new Exception();
                }

                return a;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public static String getAString(String msg, String err) {
        String str = null;
        while (true) {
            try {
                System.out.print(msg);
                str = sc.nextLine().trim();

                if (str.length() == 0 || str.isEmpty()) {
                    throw new Exception();
                }

                return str;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }

    public static String getACode(String msg, String err, String format) {
        String code = null;
        boolean check = false;

        while (true) {
            try {
                System.out.print(msg);
                code = sc.nextLine().trim().toUpperCase();
                check = code.matches(format);

                if (code.length() == 0 || code.isEmpty() || check == false) {
                    throw new Exception();
                }

                return code;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    }
}
