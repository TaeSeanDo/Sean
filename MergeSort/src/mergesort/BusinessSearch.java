package mergesort;

import java.io.File;
import java.io.IOException;



public class BusinessSearch {
    
    public static void main(String[] args) throws IOException {
        BusinessList b = new BusinessList(new File("directory.txt"));
        b.mergeSort();
        
    }
    
}