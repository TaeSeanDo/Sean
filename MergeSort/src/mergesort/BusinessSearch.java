package mergesort;

import java.io.File;
import java.io.IOException;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Education Unlimited
 */
public class BusinessSearch {
    
    public static void main(String[] args) throws IOException {
        BusinessList b = new BusinessList(new File("directory.txt"));
        b.mergeSort();
        
    }
    
}
