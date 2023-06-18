package list;

import data.Doctor;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import util.Utils;


public class DoctorList extends ObjectList<Doctor> {

    public DoctorList() {
    }

    public DoctorList(String filePath) {
        super(filePath);
    }

    /**
     * Filter by department's id
     *
     * @param id department's id
     * @return List<Doctor>
     */
    @Override
    public List<Doctor> filter(String id) {
        String depId = id.toUpperCase();
        return stream().filter((doc -> doc.getDepartmentId().toUpperCase().equals(depId))).collect(Collectors.toList());
    }

    @Override
    public List<Doctor> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Doctor parseString(String stringObject) {
        Doctor obj = new Doctor();
        obj.parseString(stringObject);
        return obj;
    }
    public void removeDoc(String id){
        if (Utils.isExistsDoctorId(id)==false){
            System.out.println("The Doctor ID does not exist");
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
