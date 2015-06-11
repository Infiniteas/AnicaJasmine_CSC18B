
package pipedreamsv6;

import java.io.Serializable;

/**
 *
 * @author Jasmine
 */
public class NewPlayerInfo implements Serializable {
    
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    
    public void setFirstName(String fname){
        this.firstName = fname;
    }
    
    public void setLastName(String lname) {
        this.lastName = lname;
    }
    
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
}
