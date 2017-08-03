/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Education Unlimited
 */
public class BusinessList {

    int numOfBusinesses;
    BusinessRecord[] businessRecords = new BusinessRecord[100];
    int numSearches;
    int numSearchesFailed;

    public BusinessList(String name) throws IOException {
        //Construct BufferedReader from InputStreamReader
        

        
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            int numOfBusinesses = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numOfBusinesses; i++) {
                String nextLine = reader.readLine();
                String busName = nextLine.split(", ")[0];
                String phNum = nextLine.split(", ")[1];
                BusinessRecord newBus = new BusinessRecord(name, phNum);
                businessRecords[i] = newBus;
                
                
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void mergeSort() {
        String[] workspace = new String[numOfBusinesses];
        recMergeSort(workspace, 0, numOfBusinesses);
    }

    public void recMergeSort(String[] workspace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int midpoint = (upperBound + lowerBound) / 2;//integer division
            recMergeSort(workspace, lowerBound, midpoint);
            recMergeSort(workspace, midpoint + 1, upperBound);
            merge(workspace, lowerBound, midpoint+1, upperBound);
        } 
        
    }
    
    public void merge(String[] workspace, int lowPointer, int highPointer, int upperBound) {
        int highPointerInit = highPointer;
        int i = 0;
        while (highPointer <= upperBound && lowPointer < highPointerInit){
            if (businessRecords[lowPointer].getName().compareTo(businessRecords[highPointer].getName()) < 0) {
                workspace[i] = businessRecords[lowPointer].getName();
                lowPointer++;
                i++;

            } else {
                workspace[i] = businessRecords[highPointer].getName();
                highPointer++;
                i++;
                
            }
            
        }
       while(highPointer > upperBound && lowPointer < highPointerInit) {
           workspace[i] = businessRecords[lowPointer].getName();
           lowPointer++;
           i++;
       }
       
       while(highPointer <= upperBound && lowPointer >= highPointerInit) {
           workspace[i] = businessRecords[highPointer].getName();
           highPointer++;
           i++;
       }
        
    }
    
    public String find(String name) {
        boolean found = false;
        int midpoint;
        while (!found) {
            
        }
        return null;
    }
    

        
        
    }
//    

