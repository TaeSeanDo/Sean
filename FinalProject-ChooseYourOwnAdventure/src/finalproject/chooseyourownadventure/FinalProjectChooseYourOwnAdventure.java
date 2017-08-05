
package finalproject.chooseyourownadventure;

import java.io.File;
import java.util.Scanner;


public class FinalProjectChooseYourOwnAdventure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adventure adventure = new Adventure(new File("adventureInput.txt"));
        
        boolean quit= false;
        while (!quit) {
            String command = sc.nextLine();
            
            switch (command) {
//                case "r":
//                    break;
                case "q":
                    quit =true;
                    break;
//                case "y":
//                    break;
                case "z":
                    adventure.backRoom();
                    break;
                case "a":
                    adventure.setRoom(adventure.history.getItem().getOptions()[0].tagString);
                    break;
                case "b":
                    adventure.setRoom(adventure.history.getItem().getOptions()[1].tagString);
                    break;
                case "c":
                    adventure.setRoom(adventure.history.getItem().getOptions()[2].tagString);
                    break;
                case "d":
                    adventure.setRoom(adventure.history.getItem().getOptions()[3].tagString);
                    break;
                case "e":
                    adventure.setRoom(adventure.history.getItem().getOptions()[4].tagString);
                    break;
                case "f":
                    adventure.setRoom(adventure.history.getItem().getOptions()[5].tagString);
                    break;
                case "g":
                    adventure.setRoom(adventure.history.getItem().getOptions()[6].tagString);
                    break;
                case "h":
                    adventure.setRoom(adventure.history.getItem().getOptions()[7].tagString);
                    break;
                case "i":
                    adventure.setRoom(adventure.history.getItem().getOptions()[8].tagString);
                    break;
                case "j":
                    adventure.setRoom(adventure.history.getItem().getOptions()[9].tagString);
                    break;
                case "k":
                    adventure.setRoom(adventure.history.getItem().getOptions()[10].tagString);
                    break;
                case "l":
                    adventure.setRoom(adventure.history.getItem().getOptions()[11].tagString);
                    break;
                default:
                    System.out.println("Not a valid option");
            }
        }
        
        
        adventure.setRoom(adventure.history.getItem().getOptions()[1].tagString);
        
        adventure.backRoom();
    }
    
}
