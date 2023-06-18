package data;

import list.IObject;
import util.Utils;


public abstract class People implements IObject, Comparable<People> {

    private static final int ATTRIBUTE_COUNT = 3;

    private String id;
    private String name;
    private String address;

    public String getId() {
        return id;
    }

    public final void setId(String id) {
        if (Utils.validateString(id, getIdPattern(), true)) {
            this.id = id.toUpperCase();
        }
    }

    public String getName() {
        return this.name;
    }

    public final void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public final void setAddress(String address) {
        if (!address.isEmpty()) {
            this.address = address;
        }
    }

    public People() {
    }

    public People(String id, String name, String address) {
        setId(id);
        setName(name);
        setAddress(address);
    }

    public void input() {
        this.id = inputId().toUpperCase();
        this.name = Utils.inputString("Please enter name (not blank or empty)").trim();
        this.address = Utils.inputString("Please enter address (not blank or empty)").trim();
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
        sb.append(this.address);
        return sb.toString();
    }

    public int parseString(String stringObject) {
        if (stringObject != null) {
            return setAttribute(stringObject.split(Utils.SEPARATOR));
        }
        return 0;
    }

    public int setAttribute(String attributes[]) {
        int idx = 0;
        if (attributes != null && attributes.length >= getAttributeCount()) {
            setId(attributes[idx++].trim());
            setName(attributes[idx++].trim());
            setAddress(attributes[idx++].trim());
        }
        return idx;
    }

    @Override
    public int compareTo(People o) {
        return this.id.compareTo(o.id);
    }

    /**
     * Get id prefix
     *
     * @return id prefix
     */
    protected abstract String getIdFormatString();
    /**
     * Get id pattern
     *
     * @return id pattern
     */
    protected abstract String getIdPattern();

    protected int getAttributeCount() {
        return People.ATTRIBUTE_COUNT;
    }

    private String inputId() {
        String inputId;
        String idFormat = getIdFormatString();
        String regex = getIdPattern();
        do {
            inputId = Utils.inputString("Please enter the id with the pattern(" + idFormat + ")");
        } while (!Utils.validateString(inputId, regex, true));

        return inputId;
    }

}
