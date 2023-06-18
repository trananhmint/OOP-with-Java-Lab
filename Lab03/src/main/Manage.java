package main;

import java.io.IOException;

import data.CD;
import list.CDList;
import util.Utils;

public class Manage {
    private final static Manage instance = new Manage();
    private CDList cdList = new CDList();

    public static Manage getInstance() {
        return instance;
    }

    public CDList getCDList() {
        return cdList;
    }

    private final static String localDirectory = System.getProperty("user.dir");

    private final String CDFilePath;

    private Manage() {
        CDFilePath = localDirectory + "\\Data\\CD.csv";
        cdList = new CDList(CDFilePath);
    }

    // case 1: Add

    private void addCD() {
        CD obj = new CD();
        obj.create();
        cdList.showHeader();
        System.out.format("|    | %-12s| %-6s| %-19s| %-8s| %-11.2f| %-16s|\n", obj.getCollection(), obj.getType(),
                obj.getTitle(), obj.getID(), obj.getUnitPrice(), obj.getPublicYear());
        cdList.showFooter();
        cdList.add(obj);
    }

    // case 2: Search CD by title

    private void searchByTitle() {
        String title = Utils.inputString("Please enter name you want to check: ", Utils.NAME_PATTERN);
        cdList.existByName(title);
    }

    // case 3: Search CD by ID

    private void searchByID() {
        String ID = Utils.inputString("Please enter the ID you want to check: ", Utils.ID_PATTERN);
        cdList.existByID(ID);
    }

    // case 4: Update CD

    public void menuUpdate() {
        System.out.println("--- UPDATE MENU ---");
        System.out.println("1 - Collection");
        System.out.println("2 - Type");
        System.out.println("3 - Title");
        System.out.println("4 - Price");
        System.out.println("5 - Delete product");
        System.out.println("Other - Quit.");
    }

    private void update() {
        int index;
        String ID;
        do {
            ID = Utils.inputString("Enter the product ID to update: ", Utils.ID_PATTERN);
            index = cdList.existByID(ID);
        } while (index < 0);

        CD obj = new CD();
        obj.setID(ID);
        int choice;

        do {
            menuUpdate();
            choice = Utils.inputInteger("Please enter your choice (from 1 to 4): ", 0, Integer.MAX_VALUE);

            switch (choice) {
                case 1: {
                    cdList.updateCollection(ID);
                    cdList.saveToFile(CDFilePath);
                    break;
                }

                case 2: {
                    cdList.updateType(ID);
                    cdList.saveToFile(CDFilePath);
                }

                case 3: {
                    cdList.updateTitle(ID);
                    cdList.saveToFile(CDFilePath);
                    break;
                }

                case 4: {
                    cdList.updateUnitPrice(ID);
                    cdList.saveToFile(CDFilePath);
                    break;
                }

                case 5: {
                    cdList.deleteCD(ID);
                    cdList.saveToFile(CDFilePath);
                }

                default: {
                    break;
                }
            }
        } while (choice < 6);
    }

    // case 5: Save

    private void saveCD() {
        cdList.saveToFile(CDFilePath);
        System.out.println("Save successfully!!!");
    }

    // case 6: Display list

    private void display() {
        cdList.showList();
    }

    // Get Data from File

    private void loadProduct() throws IOException {
        cdList.loadFromFile(CDFilePath);
    }

    private void intit() throws IOException {
        loadProduct();
    }

    // ===== MAIN MENU =====

    public void mainMenu() {
        System.out.println("--- MAIN MENU ---");
        System.out.println("1 - Add new CD to Catalog");
        System.out.println("2 - Search by Title");
        System.out.println("3 - Search by ID");
        System.out.println("4 - Update CD");
        System.out.println("5 - Save");
        System.out.println("Other - Quit.");
        
    }

    public void process() {
        int choice;
        do {
            mainMenu();
            choice = Utils.inputInteger("Please enter your choice (1-7): ", 1, Integer.MAX_VALUE);

            switch (choice) {
                case 1: {
                    addCD();
                    break;
                }

                case 2: {
                    searchByTitle();
                    break;
                }

                case 3: {
                    searchByID();
                    break;
                }

                case 4: {
                    update();
                    break;
                }

                case 5: {
                    saveCD();
                    break;
                }

                case 6: {
                    display();
                    break;
                }
            }
        } while (choice < 7);
    }

    public static void main(String[] args) throws IOException {
        Manage manage = new Manage();
        manage.intit();
        manage.process();
    }
}
