package pipedreamsv6;

/**
 *
 * @author Jasmine
 */
public class PlayerInfo {

   private int playerID;
   private String firstName;
   private String lastName;
   private String email;
   private String username;
   private String password;

   // constructor
   public PlayerInfo()
   {
   } 

   // constructor
   public PlayerInfo(int playerID, String firstName, String lastName, 
      String email, String username, String password)
   {
      setplayerID(playerID);
      setFirstName(firstName);
      setLastName(lastName);
      setEmail(email);
      setUsername(username);
      setPassword(password);
   } 

   // sets the playerID
   public void setplayerID(int playerID){
      this.playerID = playerID;
   }

   // returns the playerID 
   public int getAddressID(){
      return playerID;
   }
   
   // sets the firstName
   public void setFirstName(String firstName){
      this.firstName = firstName;
   } 

   // returns the first name 
   public String getFirstName(){
      return firstName;
   } 
   
   // sets the lastName
   public void setLastName(String lastName){
      this.lastName = lastName;
   } 

   // returns the last name 
   public String getLastName(){
      return lastName;
   }
   
   // sets the email address
   public void setEmail(String email){
      this.email = email;
   }

   // returns the email address
   public String getEmail(){
      return email;
   }
   
    // sets the username
   public void setUsername(String username){
      this.username = username;
   }

   // returns the username
   public String getUsername(){
      return username;
   } 
   
   // sets the password
   public void setPassword(String password){
      this.password = password;
   }

   // returns the password
   public String getPassword(){
      return password;
   } 
   
} // end class PlayerInfo


