
package finalproject.chooseyourownadventure;

import java.io.File;


public class FinalProjectChooseYourOwnAdventure {


    public static void main(String[] args) {
        Adventure adventure = new Adventure(new File("adventureInput.txt"));
        adventure.setRoom(adventure.history.getItem().getOptions()[1].tagString);
        adventure.backRoom();
    }
    
}
