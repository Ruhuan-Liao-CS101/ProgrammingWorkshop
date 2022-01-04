import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 * A word counter that counts the total number of each words in a file
 *
 * @author Ruhuan Liao
 * @version 10/10/21
 */
public class WordCounter
{
    public WordCounter()
    {
        HashMap<String,Integer> map = new HashMap<>();
        FileReader file = null;
        
        String fileName = JOptionPane.showInputDialog("Enter File Name");
        
        try 
        {
            file = new FileReader(fileName + ".txt"); 
        }
        catch (FileNotFoundException fnfe) 
        {
            System.out.println(fnfe); 
            System.exit(0);
        }
        
        Scanner in = new Scanner(file); 
        int count = 0;
        
        String str = "";
        
        while (in.hasNext())
        {
            str = in.next();
            if (map.containsKey(str.toLowerCase())){
                count = map.get(str.toLowerCase()) + 1;
                map.put(str.toLowerCase(),count);
                
            } else{
                count = 1;
                map.put(str.toLowerCase(),count);
            }
            
        }
            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();
            
        // TODO: Read every string in the file
        // convert every string to lowercase for matching purposes // check if the map already contains the string
        // if yes, get the existing cout from the map
        // then modify the map count with count +1
        // otherwise make a new map entry for the string with count=1

        while (it.hasNext())
        {
            String key = it.next();
            int value = map.get(key);
            System.out.println(key + " - " + value);
        }

    }  
}
