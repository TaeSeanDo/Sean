
package finalproject.chooseyourownadventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class game {
    Room[] rooms = new Room[100];
    int roomsSize = 0;
    Room[] history = new Room[100];
    int historySize = 0;
    
    public game(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Room r = new Room();
            String option = "";
           
            String currentLine = reader.readLine();
        
            while (currentLine != null) {
                
                String function = currentLine.split(" ")[0];
                StringBuilder sb = new StringBuilder(currentLine);
                sb.deleteCharAt(0);
                sb.deleteCharAt(1);
                String string = sb.toString();
                
                switch(function) {
                    case "r":
                        r.setTitle(string);
                        break;
                    case "d":
                        r.addDescription(string);
                        break;
                    case "o":
                        option = string;
                        break;
                    case "t":
                        String tab = string;
                        r.addOption(option, tab);
                        break;
                    case "\n":
                        rooms[roomsSize] = r;
                        r = new Room();
                        break;
                    default:
                        System.out.println("File does not start with key char");
                }
                
		rooms[roomsSize] = null;
                roomsSize++;
                currentLine = reader.readLine();
                
            }

	}
        catch (IOException e) {
            e.printStackTrace();
	}
    }
}
