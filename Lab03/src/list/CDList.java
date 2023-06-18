package list;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import data.CD;
import util.Utils;

public class CDList extends ObjectList<CD>{

    public CDList() {
    }

    public CDList(String filePath) {
        super(filePath);
    }

//OUTPUT
    public void showHeader() {

        System.out.println("---------- PRODUCT'S INFORMATION ----------");
        System.out.println(" ________________________________________________________________________________________");
        System.out.print("| NO ");
        System.out.print("| COLLECTION  ");
        System.out.print("| TYPE  ");
        System.out.print("| TITLE\t\t");
        System.out.print("| ID      ");
        System.out.print("| UNIT PRICE ");
        System.out.print("| PUBLISHING YEAR |\n");
        System.out.println(" ----------------------------------------------------------------------------------------");
    }

    public void showFooter() {
        System.out.println(" ----------------------------------------------------------------------------------------");
    }    

    public void output(CD obj, int check) {
        showHeader();
        System.out.format("| %-3d| %-12s| %-6s| %-19s| %-8s| %-11.2f| %-16s|\n", check + 1, obj.getCollection(), obj.getType(),
                                                                                        obj.getTitle(), obj.getID(), obj.getUnitPrice(), obj.getPublicYear());
        showFooter();
    }


//case 1: Add

    public void createCD() {
        CD obj = new CD();
        obj.create();
        showHeader();
        System.out.format("|    | %-12s| %-6s| %-19s| %-11s| %-11.2f| %-16s|\n", obj.getCollection(), obj.getType(),
                                                                                        obj.getTitle(), obj.getID(), obj.getUnitPrice(), obj.getPublicYear());
        showFooter();
        add(obj);
    }

//case 2: Search by title
    /*public CD searchName(String name) {
        for (CD obj : this) {
            if (name.equalsIgnoreCase(obj.getTitle()))
                return obj;
        }
        return null;
    }*/

    public int searchTitle(String title) {
        for (int i = 0; i < this.size(); i++) {
            if (title.equalsIgnoreCase(this.get(i).getTitle()))
                return i;
        }
        return -1;
    }

    public void existByName(String title) {
        CD obj = new CD();
        obj.setTitle(title);
        int check = searchTitle(title);
        if (check >= 0){ 
            obj = this.get(check);
            output(obj, check);
        }
        else 
            System.out.println("Your product is not exist.");
    }


//case 3: Search by ID

    public int filterById(String id) {
        int index = -1;
        if (id != null && !id.isEmpty()) {
            for (int i = 0; i < this.size(); i++) {
                if (id.equalsIgnoreCase(this.get(i).getID())) {
                    index = i;
                }
            }
        }
        return index;
    }

    public int existByID(String ID) {
        int check;
        check = filterById(ID);
        if (check >=0) {
            //obj = this.get(check);
            //output(obj,check);
            CD obj = this.get(check);
            showHeader();
            System.out.format("|    | %-12s| %-6s| %-19s| %-8s| %-11.2f| %-16s|\n", obj.getCollection(), obj.getType(),
            obj.getTitle(), obj.getID(), obj.getUnitPrice(), obj.getPublicYear());
            showFooter();
            return check;

        }
        else {
            System.out.println("Your product is not exist.");
            return check;
        }
    }

//case 4: Update CD

    //Update Product name
    public void updateCollection(String ID) {
        String name = Utils.inputString("Please enter new name: ", Utils.NAME_PATTERN);
        CD obj = new CD();
        obj.setID(ID);
        int check = indexOf(obj);
        this.get(check).setCollection(name);
        output(this.get(check), check);
    }

    public void updateType(String ID) {
        String name = Utils.inputString("Please enter new name: ", Utils.NAME_PATTERN);
        CD obj = new CD();
        obj.setID(ID);
        int check = indexOf(obj);
        this.get(check).setType(name);
        output(this.get(check), check);
    }

    public void updateTitle(String ID) {
        String name = Utils.inputString("Please enter new name: ", Utils.NAME_PATTERN);
        CD obj = new CD();
        obj.setID(ID);
        int check = indexOf(obj);
        this.get(check).setTitle(name);
        output(this.get(check), check);
    }

    public void updateUnitPrice(String ID) {
        Float price = Utils.inputFloat("Please enter new price: ", 0, 10000);
        CD obj = new CD();
        obj.setID(ID);
        int check = indexOf(obj);
        this.get(check).setUnitPrice(price);
        output(this.get(check), check);
    }
    
    public void updatePublicYear(String ID) {
        int publicYear = Utils.inputInteger("Please enter new quanity: ", 0, 1000);
        CD obj = new CD();
        obj.setID(ID);
        int check = indexOf(obj);
        this.get(check).setPublicYear(check);
        output(this.get(check), check);
    }

    //Delete Product
    public int deleteCD(String ID) {

        int s = 0;
        do {
            s = filterById(ID);
            if (s >= 0) {
                this.remove(s);
                System.out.println("Removed successfully!");
                return s = 1;
            }
            return s;
        } while (s == 0);
            
    }

//case 5: Save accounts to file
    public boolean saveToFile(String fileName) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fileName));
            for (CD obj : this) {
                pw.println(obj);
            }
            pw.close();
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


//case 6: Display the Catalog

    public void showList() {
        if (!this.isEmpty()) {
            showHeader();
            for (CD obj : this) {
                System.out.format("|    | %-12s| %-6s| %-19s| %-8s| %-11.2f| %-16s|\n", obj.getCollection(), obj.getType(),
                                                                                                obj.getTitle(), obj.getID(), obj.getUnitPrice(), obj.getPublicYear());
            }
            showFooter();
        } else
        System.out.println("Have no any product!!!");
    }

    //set File
    public CD setAttributes(String stringObject) {
        String[] arr = stringObject.split(Utils.SEPARATOR);
        int index = 0;
        String collection = arr[index++].trim();
        String type = arr[index++].trim();
        String title = arr[index++].trim();
        float unitPrice = Float.parseFloat(arr[index++].trim());
        String ID = arr[index++].trim();
        int publicYear = Integer.parseInt(arr[index++].trim());

        return new CD(collection, type, title, unitPrice, ID, publicYear);
    }

    public boolean loadFromFile(String fileName) throws IOException {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
            while (line != null) {
                this.add(setAttributes(line));
                line = br.readLine();
            }
            br.close();
            return true;
        }catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return false;
    }

//case 7: Quit.






    @Override
    public List<CD> filter(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CD> filter(Date date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected CD parseString(String stringObject) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
