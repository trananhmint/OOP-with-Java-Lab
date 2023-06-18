
package data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import util.Utils;

public class User {
    public static int ROLE_ADMIN = 0;
    public static int ROLE_USER = 1;
            
    private String id;      // user 1
    private String pass;    // xx           ==> user 1,xx,0
    private int role;       // ROLE_ADMIN

    public User() {
    }

    public User(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    
    public boolean validate() throws FileNotFoundException {
        ArrayList<String> lines;
        lines = util.Utils.readLineFromFile("Login.dat");
        for(String line:lines){
            String[] parts = line.split(Utils.SEPARATOR);
            if(parts.length<3) return false;
            if(parts[0].equalsIgnoreCase(id)&&parts[1].equalsIgnoreCase(pass)){
                this.role=Integer.parseInt(parts[2]);
                checkRole(this.role);
                return true;
            }; 
        }
        return false;
        }
        
    
    public boolean checkRole(int role) {
        if (role ==0){
            return role==ROLE_ADMIN;
        } else
        return role==ROLE_USER;
    }
    
}
