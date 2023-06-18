package list;

import data.Department;
import java.util.Date;
import java.util.List;
import util.Utils;

public class DepartmentList extends ObjectList<Department> {

    public DepartmentList() {
    }

    public DepartmentList(String filePath) {
        super(filePath);
    }

    @Override
    public List<Department> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Department> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Department parseString(String stringObject) {
        Department obj = new Department();
        obj.parseString(stringObject);
        return obj;
    }
    
    public void removeDep(String id){
        if (Utils.validateDepartmentId(id)==false){
            System.out.println("The department ID does not exist");
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
