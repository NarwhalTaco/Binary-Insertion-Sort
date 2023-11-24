/***************************************
 * CSCI 335 M01 Fall 2023
 * Ivan Yu
 * Binary Insertion Sort Project
 * 11/23/2023
****************************************/

import java.util.*;
import java.io.*;

public class Sorter {
    private File studentFile;
    private Scanner reader;
    private ArrayList<Student> studentList = new ArrayList<Student>();

    // Constructor that handles reading the file and creating an ArrayList of Students based on the inputted file
    public Sorter(String fileName) throws FileNotFoundException {
        try {
            String[] tmp = new String[4];
            studentFile = new File("./" + fileName);
            reader = new Scanner(studentFile);
            reader.nextLine();

            while (reader.hasNextLine()) {
                tmp = reader.nextLine().split(",");

                // Creates Student object and adds it to the list
                studentList.add(new Student(Integer.parseInt(tmp[0]), tmp[1], Integer.parseInt(tmp[2]), 
                        Double.parseDouble(tmp[3])));
            }

            reader.close();
        } catch (FileNotFoundException e) { // Catches error caused by not having the inputted file
            System.out.println("File was not found");
            System.exit(0);
        }
    }

    // Creates and writes the sorted list to a new file
    public void fileWriter() throws IOException {
        try {
            // Creates the new file called sortedstudents.csv
            File sortedFile = new File("sortedstudents.csv"); 
            if (sortedFile.createNewFile()) {
                System.out.println("File Created: " + sortedFile.getName());
            } else {
                System.out.println("File already exists");
            }

            // Writes to the new file in the same structure as the inputted file
            FileWriter writer = new FileWriter("sortedstudents.csv"); 
            writer.write("id,name,age,GPA\n");

            for (int i = 0; i < studentList.size() - 1; i++) {
                writer.write(studentList.get(i).getStuID() + "," + studentList.get(i).getName() + ","
                        + studentList.get(i).getAge() + "," + studentList.get(i).getGPA() + "\n");
            }
            writer.write(studentList.get(studentList.size() - 1).getStuID() + "," + studentList.get(studentList.size() - 1).getName() + ","
                    + studentList.get(studentList.size() - 1).getAge() + "," + studentList.get(studentList.size() - 1).getGPA());
            writer.close();
        } catch (IOException e) { // Catches any errors caused by file creation or file writing
            System.out.println("An error occurred");
            System.exit(0);
        }
    }

    // Implements binary insertion sort to sort the Student list based on their student ID
    public void binaryInsertionSort() {
        int left = 0;
        int right = 0;
        int middle = 0;
        int spot = 0;
        for (int i = 1; i < studentList.size(); i++) {
            // Finds the spot that the value should be inserted in the sorted subarray
            while (left <= right) { 
                if (studentList.get(i).getStuID() < studentList.get(middle).getStuID()) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
                middle = (left + right) / 2;
            }

            // Checks if the value is to be sorted at the beginning of the array
            if (!(middle < 0) && right != -1) { 
                spot = middle + 1;
            }

            int j = i - 1;
            Student tmp = studentList.get(i);

            // Shifts values down the array until the value is in its correctly sorted spot
            while (j >= spot) { 
                studentList.set(j + 1, studentList.get(j));
                studentList.set(j, tmp);
                j--;
            }

            // Sets the right pointer to its new position, resets the left pointer, the middle pointer, and insertion spot
            right = i;
            left = 0;
            middle = (left + right) / 2;
            spot = 0;
        }
    }

    // Prints out the Student list
    public void printList() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
    }

    // Main method that runs the code and provides more structure to the console print
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Sorter sorter = new Sorter(args[0]);
        System.out.println("\n------Unsorted Student List------\n");
        sorter.printList();

        sorter.binaryInsertionSort();
        System.out.println("\n------Sorted Student List------\n");
        sorter.printList();

        sorter.fileWriter();
    }
}
