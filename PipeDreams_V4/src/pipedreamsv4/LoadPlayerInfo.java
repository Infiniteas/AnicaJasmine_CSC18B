
package pipedreamsv4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jasmine
 */
public class LoadPlayerInfo {
    private static ObjectInputStream input;
    static String filename;
    static NewPlayerInfo record;
    
    public void setInfo(String username){
        filename = username;
    }
    public static void openFile(){
        String path = filename + ".ser";

        try {
            input = new ObjectInputStream(
                    Files.newInputStream(Paths.get(path)));
            
        } catch (IOException ex) {
            System.err.println("Error Opening File");
            ex.getStackTrace();
        }
    }
    
    public static void readRecords(){
        try {
            
            record = (NewPlayerInfo) input.readObject();
            /*
            System.out.println(record.getUsername());
            System.out.println(record.getEmail());
            System.out.println(record.getPassword());
            */
        } catch (IOException ex) {
            Logger.getLogger(LoadPlayerInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadPlayerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void closeFile(){
        
        try {
            if (input != null){
                input.close();
            }
        } catch (IOException ex) {
            System.err.println("Error closing file");
            Logger.getLogger(LoadPlayerInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public NewPlayerInfo getInfo(){
        return record;
    }
    
    public boolean checkFileExistence(){
        String path = filename + ".ser";
        Path filePath = Paths.get(path);
        
        if (Files.notExists(filePath)) {
            System.err.println("File does not exist");
            return false;
        }
        return true;
    }
}
