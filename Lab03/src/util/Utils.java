package util;

import java.util.Calendar;
import java.util.Scanner;

public final class Utils {

    public static Scanner sc = new Scanner(System.in);
    public static final String ID_PATTERN = "CD\\d{5}";
    public static final String NAME_PATTERN = "\\S[a-zA-Z]{4,}";
    public static final String SEPARATOR = ","; 

    public static boolean isBlank(String s) {
        if(s.trim().length() == 0) 
            return true;
        return false;
    }

    public static int year() {
        Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
        return year;
    }

    public static int inputInteger(String msg, int min, int max) {
        int value = 0;
        do {
            try {
                System.out.println(msg);
                value = Integer.parseInt(sc.nextLine());
                if (value < min || value > max) 
                    throw new Exception();
            }
            catch (Exception e) {
                System.out.println("Please enter an integer number in range!!!");
            } 
        } 
        while (value < min || value > max);
        return value;
    }

    public static float inputFloat(String msg, float min, float max) {
        float value = 0;
        do {
            try {
                System.out.println(msg);
                value = Float.parseFloat(sc.nextLine());
                if (value < min || value > max) 
                    throw new Exception();
            }
            catch (Exception e) {
                System.out.println("Please enter a real number in range!!!");
            } 
        }
        while (value < min || value > max);
        return value;
    }

    public static String inputString(String msg, String pattern) {
        String s;
        do {
            System.out.println(msg);
            s = sc.nextLine().toUpperCase();
            if (!s.matches(pattern))
                System.out.println("Please follow the format!!!");
        } while (!s.matches(pattern));
        return s;
    }

    public static String inputCollection(String msg) {
        String s;
        do {
            System.out.println(msg);
            s = sc.nextLine();
            if (s.equalsIgnoreCase("game")) 
                return "game";
            else if (s.equalsIgnoreCase("movie"))
                return "movie";
            else if (s.equalsIgnoreCase("music"))
                return "music";
        }
        while (!s.equalsIgnoreCase("game") || !s.equalsIgnoreCase("movie") || !s.equalsIgnoreCase("music"));
        return null;
    }

    public static String inputType(String msg) {
        String s;
        do {
            System.out.println(msg);
            s = sc.nextLine();
            if (s.equalsIgnoreCase("audio"))
                return "audio";
            else if (s.equalsIgnoreCase("video"))
                return "video";
        }
        while (!s.equalsIgnoreCase("audio") || !s.equalsIgnoreCase("video"));
        return null;
    }


}   