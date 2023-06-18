package data;

import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utils;

public class Patient extends People {

    public static final String ID_FORMAT = "PATxxxxx";
    private static final String ID_PATTERN = "PAT\\d{5}";
    private static final int AGE_MIN = 0;
    private static final int AGE_MAX = 120;
    private static final int ATTRIBUTE_COUNT = 1;

    private int age;

    public int getAge() {
        return age;
    }

    public final void setAge(int age) {
        if (validateAge(age)) {
            this.age = age;
        }
    }

    public Patient() {
    }

    public Patient(String id, String name, String address, int age) {
        super(id, name, address);
        setAge(age);
    }

    @Override
    public void input() {
        System.out.println("Input patient ...");
        super.input();
        this.age = Utils.inputInteger("Please enter the age (" + Patient.AGE_MIN + ", " + Patient.AGE_MAX + ")", AGE_MIN, AGE_MAX);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(Utils.SEPARATOR);
        sb.append(age);
        return sb.toString();
    }

    @Override
    public int setAttribute(String[] attributes) {
        int idx = 0;
        if (attributes != null && attributes.length >= getAttributeCount()) {
            super.setAttribute(attributes);
            idx = super.getAttributeCount();
            try {
                setAge(Integer.parseInt(attributes[idx++].trim()));
            } catch (NumberFormatException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return idx;
    }

    @Override
    protected String getIdFormatString() {
        return Patient.ID_FORMAT;
    }

    @Override
    protected String getIdPattern() {
        return Patient.ID_PATTERN;
    }

    @Override
    protected int getAttributeCount() {
        return super.getAttributeCount() + Patient.ATTRIBUTE_COUNT;
    }

    private boolean validateAge(int age) {
        return Patient.AGE_MIN <= age && age <= Patient.AGE_MAX;
    }
}
