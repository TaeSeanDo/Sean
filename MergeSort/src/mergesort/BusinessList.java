package mergesort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


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
        recMergeSort(workspace, 0, numOfBusinesses-1);
        System.out.println(Arrays.toString(businessRecords));
    }



    public void recMergeSort(BusinessRecord[] workspace, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) {
            int midpoint = (upperBound + lowerBound) / 2;//rounds down

            System.out.println("Splitting array [" + lowerBound + ", " + midpoint + "]");
            recMergeSort(workspace, lowerBound, midpoint);
            System.out.println("Done splitting array [" + lowerBound + ", " + midpoint + "]");
            
            System.out.println("Splitting array [" + (midpoint + 1) + ", " + upperBound + "]");
            recMergeSort(workspace, midpoint + 1, upperBound);
            System.out.println("Done splitting array [" + (midpoint + 1) + ", " + upperBound + "]");

            System.out.println("merging " + lowerBound + ", " + midpoint + " and " + (midpoint+1) + ", " + upperBound);
            merge(workspace, lowerBound, midpoint + 1, upperBound);
        } //else {
//            System.out.println("Array" + lowerBound);
//        }

    }

    public void merge(BusinessRecord[] workspace, int lowPointer, int highPointer, int upperBound) {

//        System.out.println("Low pointer: " + lowPointer);
//        System.out.println("High pointer: " + highPointer);
        
        int lowPointerInit = lowPointer;
        int highPointerInit = highPointer;
        int i = lowPointer;
        
        while (highPointer <= upperBound && lowPointer < highPointerInit) {
//
//            System.out.println("Low pointer: " + lowPointer);
//
//            System.out.println("High pointer: " + highPointer);
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
        
        for (int j = lowPointerInit; j <= highPointerInit; j++) {
            if (workspace[j] == null) break;
//            System.out.println(workspace[j].stringOut());
        }

//        System.out.println("Low pointer: " + lowPointer);
        while (lowPointer < highPointerInit) {
//            System.out.println("array " + lowPointerInit + ", " + highPointerInit + " at low pointer: " + businessRecords[lowPointer].stringOut());
//            System.out.println("i: " + i);
//            System.out.println("businessRecords[lowPointer]: " + businessRecords[lowPointer].stringOut());
            workspace[i] = businessRecords[lowPointer];
            System.out.println("workspace[i] = " + workspace[i].stringOut());
            i++;
            lowPointer++;
        }
        
        while (highPointer <= upperBound) {
            workspace[i] = businessRecords[highPointer];
            i++;
            highPointer++;
        }
        
        for (int j = lowPointerInit; j <= upperBound; j++) {
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
