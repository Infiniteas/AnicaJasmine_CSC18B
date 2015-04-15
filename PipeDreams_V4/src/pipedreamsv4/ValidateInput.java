
package pipedreamsv4;

/**
 *
 * @author Jasmine
 */
public class ValidateInput {
    
    public boolean validUsername(String username) {
        return username.matches("^[a-zA-Z0-9]{3,15}$");
    }
    
    public boolean validEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.]+[a-zA-Z]{3,}$");
    }

    public boolean validPassword(String password) {
       return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$");
    }

    
}
