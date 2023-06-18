
package data;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utils;


public class Login {

    private static Login instance = new Login();
    private User user;

    public static Login getInstance() {
        return instance;
    }

    public User getUser() {
        return user;
    }

    private Login() {
        user = login();
    }

    private User login() {
        System.out.println("Login ...");
        String name = Utils.inputString("user name");
        String pass = Utils.inputString("pass");
        User user = new User(name, pass);
        try {
            if (user.validate() == true) {
                return user;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
