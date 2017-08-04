package finalproject.chooseyourownadventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class game {

    Room[] rooms = new Room[100];
    int roomsSize = 0;
    DoublyLinkedListOfRooms history = new DoublyLinkedListOfRooms();

    public game(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Room r = new Room();
            String option = "";

            String currentLine = reader.readLine();

            while (currentLine != null) {

                if ("".equals(currentLine)) {
                    rooms[roomsSize] = r;
                    r = new Room();
                    continue;
                }
                String function = currentLine.split(" ")[0];
                StringBuilder sb = new StringBuilder(currentLine);
                sb.deleteCharAt(0);
                sb.deleteCharAt(1);
                String string = sb.toString();

                switch (function) {
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
                    default:
                        System.out.println("File does not start with key char");
                }

                rooms[roomsSize] = null;
                roomsSize++;
                currentLine = reader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void swap(int i, int j, Room[] array) {
        Room temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    //insertion sort the rooms by name
    public void insertionSortRooms() {

        for (int i = 0; i < roomsSize; i++) {
            int j = i;
            while ((j > 0) && (rooms[j].getTitle().compareTo(rooms[j - 1].getTitle()) < 0)) {
                swap(j - 1, j, rooms);
                j--;
            }

        }

    }
    
    public String[] RoomOut() {
        String[] roomOut = new String[200];
        int roomOutSize = 0;
        roomOut[roomOutSize] = history.getItem().getTitle();
        roomOutSize++;
        for (int i = 0; i < history.getItem().getDescriptionsSize(); i++) {
            roomOut[roomOutSize] = history.getItem().getDescriptions()[i];
            roomOutSize++;
        }
        roomOut[roomOutSize] = "Would you like to:";
        for (int i = 0; i < history.)
        return roomOut;
    }
    
    private Room binSearch(String rmName, int lowerBound, int upperBound) {
        int midpoint = (upperBound - lowerBound) / 2;
        if (rooms[midpoint].getTitle().compareTo(rmName) == 0) {
            return rooms[midpoint];
        }
        //if not found, check if midpoint is too high
        if (rooms[midpoint].getTitle().compareTo(rmName) < 0) {
            return binSearch(rmName, lowerBound, midpoint);
        }
        if (rooms[midpoint].getTitle().compareTo(rmName) < 0) {
            return binSearch(rmName, midpoint, upperBound);
        }
        return null;
    }
    
    public void switchRooms(String rmName) {
        //binary search for rmName in rooms
        Room nextRoom = binSearch(rmName, 0, roomsSize);
        history.insert(nextRoom, DoublyLinkedListOfRooms.position.LAST);
    }
    
}
