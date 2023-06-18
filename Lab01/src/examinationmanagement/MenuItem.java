package examinationmanagement;

public enum MenuItem {

    MenuDepartment(1, "Departments", 0, 0, true),
    MenuShowDepartment(1, "List all departments", 1, 1, false),
    MenuNewDepartment(2, "New department", 1, 1, false),
    MenuDeleteDepartment(3, "Delete department", 1, 1, false),
    MenuUpdateDepartment(4,"Update department",1,1,false),
    MenuDoctor(2, "Doctors", 0, 0, true),
    MenuShowDoctor(1, "List doctors", 1, 2, true),
    MenuShowDoctorAll(1, "All", 2, 2, false),
    MenuShowDoctorByDeparmentId(2, "Filter by deparment's id", 2, 2, false),
    MenuNewDoctor(3, "New doctor", 1, 2, false),
    MenuDeleteDoctor(4, "Delete doctor", 1, 2, false),
    MenuUpdateDoctor(5,"Update doctor",1,2,false),
    MenuPatient(3, "Patients", 0, 0, true),
    MenuShowPatient(1, "List all patients", 1, 3, false),
    MenuNewPatient(2, "New patient", 1, 3, false),
    MenuDeletePatient(3, "Delete patient", 1, 3, false),
    MenuUpdatePatient(4,"Update patient",1,3,false),
    MenuExamination(4, "Examinations", 0, 0, true),
    MenuShowExamination(1, "List examinations", 1, 4, true),
    MenuShowExaminationALL(1, "All", 2, 4, false),
    MenuShowExaminationByDoctorId(2, "Filter by doctor's id", 2, 4, false),
    MenuShowExaminationByDate(3, "Filter by date", 2, 4, false),
    MenuNewExamination(4, "New examination", 1, 4, false),
    MenuDeleteExamination(5, "Delete examination", 1, 4, false),
    MenuUpdateExamination(6,"Update Examination",1,4,false),
    MenuExit(0, "Exit", 0, 0, true),
    MenuShow(1, "Show menu", -1, -1, true);

    private final int id;
    private final String label;
    private final int level;
    private final int parent;
    private final boolean isParent;

    public final int getId() {
        return id;
    }

    public final String getLabel() {
        return label;
    }

    public final int getParent() {
        return parent;
    }

    public final int getLevel() {
        return level;
    }

    public final boolean isIsParent() {
        return isParent;
    }

    private MenuItem(int id, String label, int level, int parent, boolean isParent) {
        this.id = id;
        this.label = label;
        this.level = level;
        this.parent = parent;
        this.isParent = isParent;
    }

    public String show() {
        return id + ": " + label;
    }

}
