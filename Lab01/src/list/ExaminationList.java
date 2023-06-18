
package list;

import data.Examination;
import java.util.Date;
import java.util.List;
import util.Utils;

public class ExaminationList extends ObjectList<Examination> {

    public ExaminationList() {
    }

    public ExaminationList(String filePath) {
        super(filePath);
    }

    @Override
    public List<Examination> filter(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Examination> filter(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Examination parseString(String stringObject) {
        Examination obj = new Examination();
        obj.parseString(stringObject);
        return obj;
    }
    
    public void removeExa(String id){
        if (Utils.isExistsExaminationId(id)==false){
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
