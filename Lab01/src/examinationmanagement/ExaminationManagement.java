package examinationmanagement;

import data.User;
import data.Department;
import data.Doctor;
import data.Examination;
import data.Login;
import data.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import list.DepartmentList;
import list.DoctorList;
import list.ExaminationList;
import list.PatientList;
import util.Utils;


public class ExaminationManagement {

    private static final ExaminationManagement instance = new ExaminationManagement();

    private final String deparmentFilePath;
    private final String doctorFilePath;
    private final String patientFilePath;
    private final String examinationFilePath;

    private final DepartmentList departmentList;
    private final DoctorList doctorList;
    private final PatientList patientList;
    private final ExaminationList examinationtList;

    public static ExaminationManagement getInstance() {
        return instance;
    }

    public DoctorList getDoctorList() {
        return doctorList;
    }

    public DepartmentList getDeparmentList() {
        return departmentList;
    }

    public PatientList getPatientList() {
        return patientList;
    }
    
    public ExaminationList getExaminationtList() {
        return examinationtList;
    }

    private ExaminationManagement() {
        deparmentFilePath = "Department.dat";
        doctorFilePath = "Doctor.dat";
        patientFilePath = "Patient.dat";
        examinationFilePath = "Examination.dat";

        departmentList = new DepartmentList(deparmentFilePath);
        doctorList = new DoctorList(doctorFilePath);
        patientList = new PatientList(patientFilePath);
        examinationtList = new ExaminationList(examinationFilePath);
    }

    private void init() {
        loadDepartment();
        loadDoctor();
        loadPatient();
        loadExamination();
    }

    private void loadDepartment() {
        departmentList.load();
    }

    private void showDepartment() {
        departmentList.show();
    }

    private void addDepartment() {
        // check user role
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            Department dep = new Department();
            dep.input();
            departmentList.add(dep);
            departmentList.save();
        }
    }

    private void deleteDepartment() {
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            String id = Utils.inputString("Enter Department ID you want to be remove");
            departmentList.removeDep(id.toUpperCase());
        }
    }

    private void loadDoctor() {
        doctorList.load();
    }

    private void showDoctor() {
        System.out.println("Doctor list:");
        doctorList.show();
    }

    private void showFilterDoctorByDepId() {
        String id = Utils.inputString("Please enter the department's id with the pattern(" + Department.ID_FORMAT + ")");
        System.out.println("Doctor list:");
        doctorList.showFilter(id);
    }

    private void addDoctor() {
        Doctor doc = new Doctor();
        doc.input();
        
        doctorList.add(doc);
        doctorList.save();
    }

    private void deleteDoctor() {
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            String id = Utils.inputString("Enter Doctor ID you want to be remove");
            doctorList.removeDoc(id.toUpperCase());
        }
    }

    private void loadPatient() {
        patientList.load();
    }

    private void showPatient() {
        System.out.println("Patient list:");
        patientList.show();
    }

    private void addPatient() {
        Patient pati = new Patient();
        pati.input();
        patientList.add(pati);
        patientList.save();
    }

    private void deletePatient() {
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            String id = Utils.inputString("Enter Patient ID you want to be remove");
            patientList.removePat(id.toUpperCase());
        }
    }

    private void loadExamination() {
        examinationtList.load();
    }

    private void showExamination() {
        System.out.println("Examinationt list:");
        examinationtList.show();
    }

    private void showFilterExaminationByDoctorId() {
        String id = Utils.inputString("Please enter the doctor's id with the pattern(" + Doctor.ID_FORMAT + ")");
        System.out.println("Examinationt list:");
        examinationtList.showFilter(id);
    }

    private void showFilterExaminationByDate() {
        Date date = Utils.inputDate("Please enter the date filter");
        System.out.println("Examinationt list:");
        examinationtList.showFilter(date);
    }

    private void addExamination() {
        Examination exa = new Examination();
        exa.input();
        examinationtList.add(exa);
        examinationtList.save();
    }

    private void deleteExamination() {
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            String id = Utils.inputString("Enter Patient ID you want to be remove");
            examinationtList.removeExa(id.toUpperCase());
        }
    }
    
    
    // update
    public void updateDoc() {
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
            Doctor doc = new Doctor();
            doc.input();
            doctorList.remove(doc);
            doctorList.add(doc);
            doctorList.save();
        }
    }
    
    public void updateDep(){
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
        Department dep=new Department();
            dep.input();
            departmentList.remove(dep);
            departmentList.add(dep);
            
    }
    }
    
    public void updatePat(){
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
        Patient pat = new Patient();
            pat.input();
            patientList.remove(pat);
            patientList.add(pat);
    }
    }
    
    public void updateExa(){
        if (Login.getInstance().getUser().checkRole(User.ROLE_ADMIN) == true) {
        Examination exa= new Examination();
        exa.input();
        examinationtList.remove(exa);
        examinationtList.add(exa);
    }
    }
    

    private void process() {
        Menu menu = new Menu();
        int option;
        do {
            option = menu.getSelectionMenu(0);
            switch (option) {
                case 11:    // List all departments
                    showDepartment();
                    break;
                case 12:    // New department
                    addDepartment();
                    break;
                case 13:    // Delete department
                    deleteDepartment();
                    break;
                case 14:
                    updateDep();
                case 21:    // List doctors - All
                    showDoctor();
                    break;
                case 22:    // List doctors - Filter by deparment's id
                    showFilterDoctorByDepId();
                    break;
                case 23:    // New doctor
                    addDoctor();
                    break;
                case 24:    // Delete 
                    deleteDoctor();
                    break;
                case 25:
                    updateDoc();
                case 31:    //List all patients
                    showPatient();
                    break;
                case 32:    // New patient
                    addPatient();
                    break;
                case 33:    // Delete patient
                    deletePatient();
                    break;
                case 34:
                    updatePat();
                    break;
                case 41:    // List examinations - All
                    showExamination();
                    break;
                case 42:    // List examinations - Filter by doctor's id
                    showFilterExaminationByDoctorId();
                    break;
                case 43:    // List examinations - Filter by 
                    showFilterExaminationByDate();
                    break;
                case 44:    // New examination
                    addExamination();
                    break;
                case 45:    // Delete examination
                    deleteExamination();
                    break;
                case 46:
                    updateExa();
                default:
                    System.out.println("??????????");
            }
            option = menu.getSelectionExitMenu();
        } while (option != 0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (Login.getInstance().getUser() != null) {
            ExaminationManagement examMgr = ExaminationManagement.getInstance();
            examMgr.init();
            examMgr.process();
        } else {
            System.out.println("Login failed!!");
        }
    }

}
