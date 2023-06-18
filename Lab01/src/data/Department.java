package data;

import list.IObject;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utils;


public class Department implements IObject {

    public static final String ID_FORMAT = "DEPxxxxx";
    private static final String ID_PATTERN = "DEP\\d{5}";
    private static final int ATTRIBUTE_COUNT = 4;
    
    private String id;
    private String name;
    private Date createDate;
    private Date lastUpdateDate;
    
    Scanner sc = new Scanner(System.in);
    
    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if (Utils.validateString(id, Department.ID_PATTERN, true)) {
            this.id = id.toUpperCase();
        }
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public final void setCreateDate(Date createDate) {
        if (Utils.validateDate(createDate, this.lastUpdateDate)) {
            this.createDate = createDate;
        }
    }

    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public final void setLastUpdateDate(Date lastUpdateDate) {
        if (Utils.validateDate(this.createDate, lastUpdateDate)) {
            this.lastUpdateDate = lastUpdateDate;
        }
    }

    public Department() {
    }

    public Department(String id, String name, Date createDate, Date lastUpdateDate) {
        setId(id);
        setName(name);
        setCreateDate(createDate);
        setLastUpdateDate(lastUpdateDate);
    }

    public void input() {
        System.out.println("Input department ...");
        this.id = inputId().toUpperCase();
        this.name = Utils.inputString("Please enter name (not blank or empty)").trim();
        this.createDate = inputCreateDate();
        this.lastUpdateDate = inputLastUpdateDate();
    }

    public int parseString(String stringObject) {
        if (stringObject != null) {
            return setAttribute(stringObject.split(Utils.SEPARATOR));
        }
        return 0;
    }

    public int setAttribute(String[] attributes) {
        int idx = 0;
        if (attributes != null && attributes.length >= getAttributeCount()) {
            setId(attributes[idx++].trim());
            setName(attributes[idx++].trim());
            try {
                setCreateDate(Utils.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                setLastUpdateDate(Utils.toDate(attributes[idx++].trim()));
            } catch (ParseException ex) {
                Logger.getLogger(Department.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idx;
    }

    public void output() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" {");
        sb.append(toString());
        sb.append("}");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(Utils.SEPARATOR);
        sb.append(this.name);
        sb.append(Utils.SEPARATOR);
        sb.append(Utils.toString(this.createDate));
        sb.append(Utils.SEPARATOR);
        sb.append(Utils.toString(this.lastUpdateDate));
        return sb.toString();
    }

    protected int getAttributeCount() {
        return Department.ATTRIBUTE_COUNT;
    }

    private String inputId() {
        String inputId;
        do {
            inputId = Utils.inputString("Please enter the id with the pattern(" + Department.ID_FORMAT + ")");
        } while (!Utils.validateString(inputId, Department.ID_PATTERN, true));

        return inputId;
    }

    private Date inputCreateDate() {
        Date date;
        do {
            date = Utils.inputDate("Please enter create date");
        } while (!Utils.validateDate(date, this.lastUpdateDate));
        return date;
    }

    private Date inputLastUpdateDate() {
        Date date;
        do {
            date = Utils.inputDate("Please enter last update date");
        } while (!Utils.validateDate(this.createDate, date));
        return date;
    }
    
   
}
