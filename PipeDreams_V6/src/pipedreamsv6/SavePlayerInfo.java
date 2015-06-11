
package pipedreamsv6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 *
 * @author Jasmine
 */
public class SavePlayerInfo {
    
    private static ObjectOutputStream output;
    private static NewPlayerInfo info = new NewPlayerInfo();
    
    public void setInfo(NewPlayerInfo info){
        this.info = info;
    }
    
    public static void openFile(){
        String path = info.getUsername()+".ser";
        
        try {
            output = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(path)));
        } catch (IOException ex) {
            ex.getStackTrace();
        }
        
    }
    
    public static void addRecords(){
        try {
            output.writeObject(info);
        } catch (IOException ex) {
            System.err.println("Error writing to file");
            ex.getStackTrace();
        }
    }
    
    public static void closeFile(){
        try {
            if(output != null){
                output.close();
            }
        } catch (IOException ex) {
            System.err.println("Error closing file");
            ex.getStackTrace();
        }
    }
}
