package data;

import list.IObject;
import util.Utils;

public class CD implements IObject {
    public static Object updateCollection;
    String collection;
    String type;
    String title;
    float unitPrice;
    String ID;
    int publicYear;

    public CD() {
    }

    public CD(String collection, String type, String title, float unitPrice, String iD, int publicYear) {
        setCollection(collection);
        setType(type);
        setTitle(title);
        setUnitPrice(unitPrice);
        setID(iD);
        setPublicYear(publicYear);
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = (!Utils.isBlank(collection))? collection.toLowerCase().trim() : null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = (!Utils.isBlank(type))? type.toLowerCase().trim() : null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = (!Utils.isBlank(title))? title.toUpperCase().trim() : null;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = (unitPrice >= 0)? unitPrice : 0;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = (!Utils.isBlank(ID))? ID.toUpperCase().trim() : null;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = (publicYear >= 1980 && publicYear <= Utils.year())? publicYear : 1980;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.collection);
        sb.append(Utils.SEPARATOR);
        sb.append(this.type);
        sb.append(Utils.SEPARATOR);
        sb.append(this.title);
        sb.append(Utils.SEPARATOR);
        sb.append(this.unitPrice);
        sb.append(Utils.SEPARATOR);
        sb.append(this.ID);
        sb.append(Utils.SEPARATOR);
        sb.append(this.publicYear);
        return sb.toString();
    }

    //===== CREATE CD ======
    public void create() {
        this.collection = Utils.inputCollection("Please enter the collection (game/movie/music): ");
        this.type = Utils.inputType("Please enter the type (audio/video): ");
        this.title = Utils.inputString("Please enter the title: ", Utils.NAME_PATTERN);
        this.ID = Utils.inputString("Please enter the ID (CDxxxxxx): ", Utils.ID_PATTERN);
        this.unitPrice = Utils.inputFloat("Please enter the price: ", 0, Float.MAX_VALUE);
        this.publicYear = Utils.inputInteger("Please enter the publishing year (1980-now): ", 1980, Utils.year());
    }

    // ===== UPDATE CD =====
    public void upCollection(String ID) {
        collection = Utils.inputCollection("Please enter the new collection (game/movie/music): ");
        setCollection(collection);
    }

    public void upType(String ID) {
        type = Utils.inputType("Please enter the new type (audio/video): ");
        setType(type);
    }

    public void upTitle(String ID) {
        title = Utils.inputString("Please enter the new title: ", Utils.NAME_PATTERN);
        setTitle(title);
    }

    public void upUnitPrice(String ID) {
        unitPrice = Utils.inputFloat("Please enter the new price :", 0, Float.MAX_VALUE);
        setUnitPrice(unitPrice);
    }

    public void upPublicYear(int publicYear) {
        publicYear = Utils.inputInteger("Please enter the new publishing year (1980 - 2022)", 1980, Utils.year());
        setPublicYear(publicYear);
    }


    @Override
    public void output() {
        // TODO Auto-generated method stub
        
    }


}
