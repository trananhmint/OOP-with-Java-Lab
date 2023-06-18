package examinationmanagement;

import util.Utils;


public class Menu {

    private static final String INDENT_STRING = "  ";
    private static final String COLON_STRING = ":";

    public int getSelectionMenu(int level) {
        showMenu(level);
        int option = Utils.inputInteger("Please enter your choice", 0, 100);
        if (option == MenuItem.MenuDepartment.getId()) {
            showMenu(MenuItem.MenuDepartment.getId());
            option = 10 * option + Utils.inputInteger("Please enter your choice", 0, 100);
        } else if (option == MenuItem.MenuDoctor.getId()) {
            showMenu(MenuItem.MenuDoctor.getId());
            option = 10 * option + Utils.inputInteger("Please enter your choice", 0, 100);
        } else if (option == MenuItem.MenuPatient.getId()) {
            showMenu(MenuItem.MenuPatient.getId());
            option = 10 * option + Utils.inputInteger("Please enter your choice", 0, 100);
        } else if (option == MenuItem.MenuExamination.getId()) {
            showMenu(MenuItem.MenuExamination.getId());
            option = 10 * option + Utils.inputInteger("Please enter your choice", 0, 100);
        }
        return option;
    }

    public int getSelectionExitMenu() {
        showExitMenu();
        return Utils.inputInteger("Please enter your choice", 0, 100);
    }

    private void showExitMenu() {
        System.out.println("******** Menu ********");
        System.out.println(MenuItem.MenuShow.show());
        System.out.println(MenuItem.MenuExit.show());
    }

    private void showMenu(int level) {        
        if (level == 0) {
            System.out.println("******** Menu ********");
            for (MenuItem item : MenuItem.values()) {
                if (level == item.getParent()) {
                    System.out.println(item.show());
                }
            }
        } else {
            System.out.println("**********************");
            for (MenuItem item : MenuItem.values()) {
                if (level == item.getId() && item.getParent() == 0) {
                    System.out.println(item.getLabel() + Menu.COLON_STRING);
                } else if (level == item.getParent()) {
                    if (item.isIsParent()) {
                        System.out.println(getIndent(item.getLevel()) + item.getLabel() + Menu.COLON_STRING);
                    } else {
                        System.out.println(getIndent(item.getLevel()) + item.show());
                    }
                }
            }
        }
        System.out.println("**********************");
    }

    private String getIndent(int level) {
        String strIndent = "";
        for (int i = 0; i < level; i++) {
            strIndent += Menu.INDENT_STRING;
        }
        return strIndent;
    }
}
