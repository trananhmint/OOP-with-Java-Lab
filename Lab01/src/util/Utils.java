package util;

import data.Department;
import data.Doctor;
import data.Examination;
import data.Patient;
import examinationmanagement.ExaminationManagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class Utils {

    public static final String SEPARATOR = ",";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String IGNORE_CASE_PATTERN = "(?i)";

    public static int inputInteger(String message, int minValue, int maxValue) {
        int val = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            try {
                val = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < minValue || maxValue < val);
        return val;
    }

    public static String inputString(String message) {
        String inputString;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(message + ": ");
            inputString = sc.nextLine();
        } while (inputString.isEmpty());
        return inputString;
    }

    public static Date toDate(String strDate) throws ParseException {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(Utils.DATE_FORMAT);
        df.setLenient(false);
        return df.parse(strDate);
    }

    public static String toString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(Utils.DATE_FORMAT);
        return df.format(date);
    }

    public static Date inputDate(String message) {
        Scanner sc = new Scanner(System.in);
        Date date = null;
        do {
            System.out.print(message + "(" + Utils.DATE_FORMAT + "): ");
            try {
                date = toDate(sc.nextLine());
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (date == null);
        return date;
    }

    public static boolean inputBoolean(String message) {
        System.out.print(message + "(" + Boolean.TRUE.toString() + "/" + Boolean.FALSE.toString() + "or male/female): ");
        Scanner sc = new Scanner(System.in);
        return Boolean.parseBoolean(sc.nextLine());
    }

    public static boolean validateString(String str, String regex, boolean ignoreCase) {
        if (str != null && regex != null) {
            if (ignoreCase) {
                regex = Utils.IGNORE_CASE_PATTERN + regex;
            }
            return str.matches(regex);
        }
        return false;
    }

    public static boolean validateDate(Date createDate, Date lastUpdateDate) {
        Date now = new Date();
        if (createDate == null) {
            return lastUpdateDate != null && !lastUpdateDate.after(now);
        } else if (lastUpdateDate == null) {
            return !createDate.after(now);
        }
        return !createDate.after(lastUpdateDate) && !lastUpdateDate.after(now);
    }

    public static boolean validateDepartmentId(String id) {
        if (id != null && !id.isEmpty()) {
            Department obj = new Department();
            obj.setId(id);
            return ExaminationManagement.getInstance().getDeparmentList().contains(obj);
        }
        return false;
    }

    public static boolean isExistsDoctorId(String id) {
        if (id != null && !id.isEmpty()) {
            Doctor obj = new Doctor();
            obj.setId(id);
            return ExaminationManagement.getInstance().getDoctorList().contains(obj);
        }
        return false;
    }

    public static boolean isExistsPatientId(String id) {
        if (id != null && !id.isEmpty()) {
            Patient obj = new Patient();
            obj.setId(id);
            return ExaminationManagement.getInstance().getPatientList().contains(obj);
        }
        return false;
    }
    
    public static boolean isExistsExaminationId(String id){
        if (id != null && !id.isEmpty()) {
            for (Examination e : ExaminationManagement.getInstance().getExaminationtList()) {
                if (e.getId().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

//    public static void readLineFormFile(String filepath) throws FileNotFoundException{
//        try{
//        Scanner scanner = new Scanner(new File(filepath));
//			while (scanner.hasNextLine()) {
//				System.out.println(scanner.nextLine());
//			}
//			scanner.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//    }

    public static ArrayList<String> readLineFromFile(String logindat) throws FileNotFoundException{
        ArrayList<String> list = new ArrayList();
        try {
            Scanner sc;
            sc = new Scanner(new File(logindat));
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                list.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    private Utils() {
    }
}
