/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Education Unlimited
 */
public class BusinessList {

    BusinessRecord[] businessRecords = new BusinessRecord[100];
    int numSearches;
    int numSearchesFailed;
    int numOfBusinesses;

    public BusinessList(File fin) throws IOException {
//        FileInputStream fis = new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        try (BufferedReader br = new BufferedReader(new FileReader(fin))) {
            numOfBusinesses = Integer.parseInt(br.readLine());
            for (int i = 0; i < numOfBusinesses; i++) {
                String nextLine = br.readLine();
                String name = nextLine.split(", ")[0];
                String phNum = nextLine.split(", ")[1];
                BusinessRecord newBus = new BusinessRecord(name, phNum);
                businessRecords[i] = newBus;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void mergeSort() {
        BusinessRecord[] workspace = new BusinessRecord[numOfBusinesses];
        recMergeSort(workspace, 0, numOfBusinesses);
        System.out.println(Arrays.toString(businessRecords));
    }

    public void recMergeSort(BusinessRecord[] workspace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int midpoint = (upperBound + lowerBound) / 2;//integer division
            recMergeSort(workspace, lowerBound, midpoint);
            recMergeSort(workspace, midpoint + 1, upperBound);
            merge(workspace, lowerBound, midpoint + 1, upperBound);
        }

    }

    public void merge(BusinessRecord[] workspace, int lowPointer, int highPointer, int upperBound) {
        int lowPointerInit = lowPointer;
        int highPointerInit = highPointer;
        int i = lowPointer;
        
        while (highPointer <= upperBound && lowPointer < highPointerInit) {
            System.out.println("Low pointer: " + lowPointer);
            System.out.println("High pointer: " + highPointer);
            if (businessRecords[lowPointer].getName().compareTo(businessRecords[highPointer].getName()) < 0) {
                workspace[i] = businessRecords[lowPointer];
                i++;
                lowPointer++;
            } else {
                workspace[i] = businessRecords[highPointer];
                i++;
                highPointer++;

            }
        }

        while (lowPointer < highPointerInit) {
            workspace[i] = businessRecords[lowPointer];
            i++;
            lowPointer++;
        }
        
        while (highPointer <= upperBound) {
            workspace[i] = businessRecords[highPointer];
            i++;
            highPointer++;
        }
        
        for (int j = lowPointerInit; j <= highPointerInit; j++) {
            System.out.println(workspace[j].stringOut());
            BusinessRecord br = new BusinessRecord(workspace[j].getName(), workspace[j].getPhNum());
            businessRecords[j] = br;
        }
        
        System.out.println("end\n");

    }

//    public String find() {
//        boolean found = false;
//        int midpoint
//        while (!found) {
//            
//        }
//    }
}
