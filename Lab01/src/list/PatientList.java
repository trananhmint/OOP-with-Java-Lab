package list;

import data.Patient;
import java.util.Date;
import java.util.List;
import util.Utils;


public class PatientList extends ObjectList<Patient> {

    public PatientList() {
    }

    public PatientList(String filePath) {
        super(filePath);
    }

    @Override
    public List<Patient> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Patient> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Patient parseString(String stringObject) {
        Patient obj = new Patient();
        obj.parseString(stringObject);
        return obj;
    }
    
    public void removePat(String id){
        if (Utils.isExistsPatientId(id)==false){
            System.out.println("The Patient ID does not exist");
        }
        else {
            for (int i=0;i< size();i++){
                if (this.get(i).getId().equals(id)){
                    this.remove(i);
                }
            }
            System.out.println("Removed succesfully");
        }
    }
    

}
