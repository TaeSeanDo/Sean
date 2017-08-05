package finalproject.chooseyourownadventure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Adventure {

    Room[] rooms = new Room[100];
    int roomsSize = 0;
    DoublyLinkedListOfRooms history = new DoublyLinkedListOfRooms();

    public Adventure(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            Room r = new Room();
            String option = "";

            String currentLine = reader.readLine();

            while (currentLine != null) {

                if ("".equals(currentLine)) {
                    rooms[roomsSize] = r;
                    roomsSize++;
                    r = new Room();
                    currentLine = reader.readLine();
                    continue;
                }
                String function = currentLine.split(" ")[0];
                StringBuilder sb = new StringBuilder(currentLine);
//                char[] deleted = new char[100];
//                sb.getChars(0, 2, deleted, 0);
//                System.out.println("0: "+deleted[0] +", 1: "+deleted[1]+", 2: "+deleted[2]);
                sb.deleteCharAt(0);
                sb.deleteCharAt(0);
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
                        System.err.println("File does not start with key char");
                }
                currentLine = reader.readLine();

            }
            
            rooms[roomsSize] = r;
            roomsSize++;

        } catch (IOException e) {
            e.printStackTrace();
        }

        Room temp = rooms[0];
        insertionSortRooms();
        setRoom(temp.getTitle());

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

    private String[] RoomOutput() {
        String[] roomOut = new String[200];
        int roomOutSize = 0;
        roomOut[roomOutSize] = "Room: " + history.getItem().getTitle();
        roomOutSize++;
        for (int i = 0; i < history.getItem().getDescriptionsSize(); i++) {
            roomOut[roomOutSize] = history.getItem().getDescriptions()[i];
            roomOutSize++;
        }

        int unicodeLtr = 97;
        roomOut[roomOutSize] = "Would you like to:";
        roomOutSize++;
        for (int i = 0; i < history.getItem().getOptionsSize(); i++) {
            String temp = Character.toString((char) unicodeLtr) + ". ";
            temp += history.getItem().getOptions()[i].optString;
            temp += " (to " + history.getItem().getOptions()[i].tagString + ")";
            roomOut[roomOutSize] = temp;
            roomOutSize++;
            unicodeLtr++;
        }
        roomOut[roomOutSize] = "";
        return roomOut;
    }

    public void printRoom() {
        for (String i : RoomOutput()) {
            if (i == null) {
                break;
            }
            System.out.println(i);
        }
    }

    private Room binSearch(String rmName, int lowerBound, int upperBound) {
        int midpoint = (lowerBound + upperBound) / 2;
        System.out.println("Calling search " + lowerBound + " , " + upperBound);
        if (rooms[midpoint].getTitle().compareTo(rmName) == 0) {
            return rooms[midpoint];
        } else if (lowerBound == upperBound) {
            return null;
        } else {
            if (rooms[midpoint].getTitle().compareTo(rmName) > 0) {
                return binSearch(rmName, lowerBound, midpoint-1);
            } else {
                System.out.println("Attempting to call search on " + (int )(midpoint+1) + ", "+upperBound);
                return binSearch(rmName, midpoint+1, upperBound);
            }
        }

    }
    
    private Room SeqSearch(String rmName) {
        for (int i = 0; i < roomsSize; i++) {
            if (rmName.equals(rooms[i].getTitle())) {
                return rooms[i];
            }
        }
        return null;
    }
    
    

    public void setRoom(String rmName) {
        //binary search for rmName in rooms
        Room nextRoom = binSearch(rmName, 0, roomsSize-1);
        history.insert(nextRoom, DoublyLinkedListOfRooms.position.LAST);
        printRoom();
    }
    
    public void backRoom() {
        history.delete();
        printRoom();
    }

}
