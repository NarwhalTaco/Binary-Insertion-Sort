public class Student {
    private int studentID, age;
    private String name;
    private double GPA;

    public Student(int sID, int age, String name, double GPA) {
        this.studentID = sID;
        this.age = age;
        this.name = name;
        this.GPA = GPA;
    }

    public int getStuID()   {return this.studentID;}
    public int getAge()     {return this.age;}
    public String getName() {return this.name;}
    public double getGPA()  {return this.GPA;}

    // Returns Student object as a String
    public String toString() {
        String tmp = "";
        tmp += "****************";
        tmp += "Student ID: " + getStuID();
        tmp += "Name: " + getName();
        tmp += "Age: " + getAge();
        tmp += "GPA: " + getGPA();
        tmp += "****************";
        return tmp;
    }
}
