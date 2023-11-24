/***************************************
 * CSCI 335 M01 Fall 2023
 * Ivan Yu
 * Binary Insertion Sort Project
 * 11/23/2023
****************************************/

public class Student {
    private int studentID, age;
    private String name;
    private double GPA;

    // Constructor that creates Student objects
    public Student(int sID, String name, int age, double GPA) {
        this.studentID = sID;
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    // Only getters are required because we don't alter the variables of Student objects
    public int getStuID()   {return this.studentID;}
    public String getName() {return this.name;}
    public int getAge()     {return this.age;}
    public double getGPA()  {return this.GPA;}

    // Returns Student object as a String
    public String toString() {
        String tmp = "";
        tmp += "****************\n";
        tmp += "Student ID: " + getStuID() + "\n";
        tmp += "Name: " + getName() + "\n";
        tmp += "Age: " + getAge() + "\n";
        tmp += "GPA: " + getGPA() + "\n";
        tmp += "****************\n";
        return tmp;
    }
}
